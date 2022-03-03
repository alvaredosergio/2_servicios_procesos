package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements CalculadoraInterface {
    
    private static final long serialVersionUID = 7203096671732233792L;

    public Calculadora() throws RemoteException {
        super();
    }

    @Override
    public int division(int n1, int n2) throws RemoteException {
        return n1/n2;
    }

    @Override
    public int multiplicacion(int n1, int n2) throws RemoteException {
        return n1*n2;
    }

    @Override
    public int resta(int n1, int n2) throws RemoteException {
        return n1-n2;
    }

    @Override
    public int suma(int n1, int n2) throws RemoteException {
        return n1+n2;
    }
    
}
