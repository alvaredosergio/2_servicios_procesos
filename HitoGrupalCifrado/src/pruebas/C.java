package pruebas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class C {
    public static void main(String[] args) {
        try {
            // Creamos un socket para conectarse con la IP del servidor, y al puerto por el que escucha.
            Socket socket = new Socket("127.0.0.1", 5111);
            System.out.print("\033[H\033[2J");
            System.out.println("Usuario CONECTADO.");

            // Creamos los DataInput y Output para mandar y recibir mensajes.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salidaClave = new DataOutputStream(socket.getOutputStream());
            OutputStream salidaMensaje = socket.getOutputStream();
            
            // Determinamos la clave, y la enviamos.
            String claveCliente = "1234";
            salidaClave.writeUTF(claveCliente);

            Cif cifa = new Cif(claveCliente);
            byte[] mensajeEncriptado = cifa.cifrarMensaje("s");
            salidaMensaje.write(mensajeEncriptado);

            // Cerramos las conexiones.
            entrada.close();
            salidaClave.close();
            salidaMensaje.close();
            socket.close();
            System.out.println("SERVIDOR CERRADO.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
