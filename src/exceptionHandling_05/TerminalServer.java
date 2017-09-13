package exceptionHandling_05;

import java.net.ConnectException;
import java.rmi.server.ServerNotActiveException;
import java.util.Random;

public class TerminalServer {
    private float amount;
    private Random random = new Random();

    public boolean isLockedAccount() {
        return isLockedAccount;
    }

    public long getAccountLockTime() {
        return accountLockTime;
    }

    private boolean isLockedAccount = false;
    private long accountLockTime;


    public float checkAccount() throws ConnectException, ServerNotActiveException {
        if (isLockedAccount) throw new ServerNotActiveException("Счет заблокирован, повторите попытку позже");
        generateRandomConnectException();
        return this.amount;
    }

    public void putCash(float amount) throws ConnectException, ServerNotActiveException {
        if (isLockedAccount) throw new ServerNotActiveException("Счет заблокирован, повторите попытку позже");
        generateRandomConnectException();
        this.amount += amount;
    }

    public void getCash(float amount) throws IllegalArgumentException,ConnectException, ServerNotActiveException {
        if (isLockedAccount) throw new ServerNotActiveException("Счет заблокирован, повторите попытку позже");
        generateRandomConnectException();
        if (this.amount-amount<0)
            throw new IllegalArgumentException("На Вашем счете недостаточно средств, повторите попытку, указав меньшую сумму");
        this.amount -= amount;
    }

    public void generateRandomConnectException() throws ConnectException {

        if (random.nextInt()%7==0){
            throw new ConnectException("Ошибка подключения к серверу приложения, повторите попытку позже.");
        }

    }

    public void lockAccount(){
        this.isLockedAccount = true;
        this.accountLockTime = System.currentTimeMillis();
    }

    public void unLockAccount(){
        this.isLockedAccount = false;
        this.accountLockTime = 0;
    }

}
