package exceptionHandling_05;

import java.net.ConnectException;
import java.rmi.server.ServerNotActiveException;

public class Terminal implements ITerminal {
    private final TerminalServer terminalServer = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();
    private boolean isPinValidated = false;
    private int validateFailsCount = 0;

    public void validatePin(String pin) throws AccountIsLockedException {
        if (terminalServer.isLockedAccount() && (5 - (System.currentTimeMillis() - terminalServer.getAccountLockTime()/1000))<=0)
            terminalServer.unLockAccount();
        if (terminalServer.isLockedAccount())
            throw new AccountIsLockedException("Ваш аккаунт временно заблокирован");


        if(pinValidator.validatePin(pin)){
            isPinValidated = true;
            validateFailsCount = 0;
        }else{

            isPinValidated = false;
            validateFailsCount ++;
            if (validateFailsCount > 3){
                terminalServer.lockAccount();
                throw new AccountIsLockedException("Ваш аккаунт временно заблокирован");
            }
            throw new IllegalArgumentException("Неверный пин");
        }


    }

    @Override
    public float checkAccount() throws ServerNotActiveException, ConnectException {
        if (isPinValidated)
            return terminalServer.checkAccount();
        else throw new SecurityException("Авторизуйтесь");
    }

    @Override
    public void putCash(float amount) throws ServerNotActiveException, ConnectException {
        if (isPinValidated)
            terminalServer.putCash(amount);
        else throw new SecurityException("Авторизуйтесь");
    }

    @Override
    public void getCash(float amount) throws ServerNotActiveException, ConnectException {
        if (isPinValidated)
            if (amount%100 != 0) throw new IllegalArgumentException("Сумма должна быть кратна 100");
            else
                terminalServer.getCash(amount);
        else throw new SecurityException("Авторизуйтесь");
    }
}
