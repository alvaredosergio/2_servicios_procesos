package pruebas;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Cif {
    private Cipher cipher; 
    private PrivateKey prik; 
    private PublicKey pubk;

    public Cif(String clave) {
        try {
            cipher = Cipher.getInstance("RSA");
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            KeyPair kp = kpg.generateKeyPair();
            prik = kp.getPrivate();
            pubk = kp.getPublic();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } 
    } 

    public byte[] cifrarMensaje (String mensaje) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, pubk);
            byte [] cifrado = cipher.doFinal(mensaje.getBytes());
            return cifrado;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String descifrarMensaje (byte[] cifrado){
        try {
            cipher.init(Cipher.DECRYPT_MODE, prik);
            byte[] descifrado = cipher.doFinal(cifrado);
                return new String (descifrado); 
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
