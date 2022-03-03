package simetrico;

public class Main {
    public static void main(String[] args) {
        Cifrado cif = new Cifrado("1234");
        byte[] mensaje = cif.cifrarMensaje("hola");
        System.out.println(new String(mensaje));
        String mensajedes = cif.descifrarMensaje(mensaje);
        System.out.println(mensajedes);


        ObjetoSimple os = new ObjetoSimple("hola", 20);
        
        byte[] objeto = cif.cifrarObjeto(os);
        System.out.println(new String(objeto));

        ObjetoSimple os2 = (ObjetoSimple) cif.descifrarObjeto(objeto);
        System.out.println(os2.toString());

    }
}
