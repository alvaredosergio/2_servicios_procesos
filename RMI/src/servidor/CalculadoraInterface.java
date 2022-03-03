package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraInterface extends Remote {
    // --- Interfaz Calculadora con metodos de calculo ABSTRACTOS, para poder implementar sus metodos.
    
    public int suma(int n1, int n2) throws RemoteException; // --- Esta excepción se lanza si se pierde la comunicación con el Servidor.
    public int resta(int n1, int n2) throws RemoteException;
    public int multiplicacion(int n1, int n2) throws RemoteException;
    public int division(int n1, int n2) throws RemoteException;
    
}
