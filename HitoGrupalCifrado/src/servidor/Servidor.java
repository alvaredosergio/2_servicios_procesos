package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import cifrado.CifradoAsimetrico;

public class Servidor {
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String reset = "\u001B[0m";
    public static final String cyan = "\u001B[36m";

    public static void main(String[] args) {
        try {
            // Socket del servidor para especificar el puerto por el que escucha.
            ServerSocket ss = new ServerSocket(5111);
            System.out.print("\033[H\033[2J");
            System.out.println("Servidor " + yellow + "ACTIVO" + reset +  ", esperando usuarios..." + reset);

            // Creamos un Socket para aceptar la conexion con el ServerSocket
            Socket socket = ss.accept();
            System.out.print("\033[H\033[2J");
            System.out.println(green +  "Usuario CONECTADO." + reset);
            

            // Creamos un DataInputStream y un OutputStream, para la entrada y salida de datos.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // Mensaje va a leer la entrada del DataInputStream, y con readUTF puede leer texto.

            //------------ Aqui recibo lo que me ESCRIBE EL CLIENTE (mensajeRecibido)
            String claveRecibida = entrada.readUTF();
            CifradoAsimetrico cifa = new CifradoAsimetrico(claveRecibida);
            System.out.println(cyan + "(Clave de usuario): " + reset + claveRecibida);

            while (true) {
                Scanner sc = new Scanner (System.in);
                salida.writeUTF(sc.nextLine());

                // Pintamos el mensaje.
                String mensaje = entrada.readUTF();
                String cifrado = cifa.descifrarMensaje(mensaje.getBytes());

                System.out.println(cyan + "Usuario: " + reset + cifrado);
            }
            
            // IMPORTANTE cerrar todos los recursos que no vamos a utilizar mas, entrada,salida, el socket, y si vamos a finalizar el servidor, ServerSocket.close
            /*entrada.close();
            salida.close();
            socket.close();
            ss.close();
            System.out.println(red + "SERVIDOR CERRADO." + reset);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
