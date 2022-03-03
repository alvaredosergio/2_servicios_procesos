import cifrado.CifradoAsimetrico;

public class Pruebas {
    public static void main(String[] args) {
        CifradoAsimetrico cifa = new CifradoAsimetrico("1234");
        byte[] mensaje = cifa.cifrarMensaje("HolaHOLA");
        System.out.println(new String (mensaje));
        System.out.println(cifa.descifrarMensaje(mensaje));
    }
}
