package exceptionHandling_05;

import java.rmi.server.ServerNotActiveException;

public class AccountIsLockedException extends ServerNotActiveException {
    public AccountIsLockedException(String s) {
        super(s);
    }
}
