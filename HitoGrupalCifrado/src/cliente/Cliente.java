package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import cifrado.CifradoAsimetrico;

public class Cliente {
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String reset = "\u001B[0m";
    public static final String cyan = "\u001B[36m";
    public static void main(String[] args) {
        try {
            System.out.println("Introduzca su usuario: ");
            Scanner scn1 = new Scanner(System.in);
            String user1 = scn1.nextLine();

            // Creamos un socket para conectarse con la IP del servidor, y al puerto por el que escucha.
            Socket socket = new Socket("127.0.0.1", 5111);
            System.out.print("\033[H\033[2J");
            System.out.println("Usuario " + cyan + user1 + green + " CONECTADO." + reset);

            // Creamos los DataInput y Output para mandar y recibir mensajes.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            
            // Escribimos el mensaje al recibir conexion con el server.
            while (true) {
                Scanner sc = new Scanner (System.in);
                String mensajeAenviar = sc.nextLine();
                CifradoAsimetrico cifa = new CifradoAsimetrico("1234");
                byte[] mensajeCifrado = cifa.cifrarMensaje(mensajeAenviar);
                salida.write(mensajeCifrado);
            
                // Pintamos el mensaje recibido.
                String mensaje = entrada.readUTF();

                System.out.println(cyan + "Servidor: " + reset + mensaje);
            }
            // Cerramos las conexiones.
            /*entrada.close();
            salida.close();
            socket.close();
            System.out.println(red + "SERVIDOR CERRADO." + reset);*/

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
