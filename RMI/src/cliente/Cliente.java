package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import servidor.CalculadoraInterface;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.getRegistry(5031);
            CalculadoraInterface ci = (CalculadoraInterface)Naming.lookup("//localhost:5031/calculadora");
            System.out.println("Suma = " + ci.suma(5, 5));
            System.out.println("Resta = " + ci.resta(6, 2));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
}
