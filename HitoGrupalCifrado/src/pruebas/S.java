package pruebas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class S{
    public static void main(String[] args) {
        try {
            // Socket del servidor para especificar el puerto por el que escucha.
            ServerSocket ss = new ServerSocket(5111);
            System.out.println("Servidor activo, esperando usuarios...");

            // Creamos un Socket para aceptar la conexion con el ServerSocket
            Socket socket = ss.accept();
            System.out.print("\033[H\033[2J");
            System.out.println("Usuario CONECTADO.");
            
            // Creamos un DataInputStream y un OutputStream, para la entrada y salida de datos.
            DataInputStream entradaClave = new DataInputStream(socket.getInputStream());
            InputStream entradaMensaje = socket.getInputStream();
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            
            String clave = entradaClave.readUTF();

            /*------------------------ AQUI PERSISTE EL FALLO --------------------------*/
            byte[] mensajeRecibido = new byte[256];
            
            int bLeidos = entradaMensaje.read(mensajeRecibido);
            byte[] mensajeFinal = new byte [bLeidos];
            for(int i = 0; i < bLeidos; i++){
                mensajeFinal[i] = mensajeRecibido[i];            }
            Cif cifa = new Cif(clave);
            String mensajeDescifrado = cifa.descifrarMensaje(mensajeFinal);
            System.out.println(mensajeDescifrado);
            /*--------------------------------------------------------------------------*/

            entradaClave.close();
            entradaMensaje.close();
            salida.close();
            socket.close();
            ss.close();
            System.out.println("SERVIDOR CERRADO.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
