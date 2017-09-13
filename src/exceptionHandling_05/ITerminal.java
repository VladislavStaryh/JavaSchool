package exceptionHandling_05;

import java.net.ConnectException;
import java.rmi.server.ServerNotActiveException;

public interface ITerminal {
    float checkAccount() throws ServerNotActiveException, ConnectException;
    void putCash(float amount) throws ServerNotActiveException, ConnectException;
    void getCash(float amount) throws ServerNotActiveException, ConnectException;
}
