package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {

        // Instanciamos nuestro objeto Calculadora
        try {
            LocateRegistry.createRegistry(5031);
            CalculadoraInterface cal = new Calculadora();
            System.out.println("Servidor 2 Listo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
