package simetrico;

import java.io.Serializable;

public class ObjetoSimple implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String texto;
    private int numero;

    public ObjetoSimple(String texto, int numero) {
        super();
        this.texto = texto;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "ObjetoSimple [numero=" + numero + ", texto=" + texto + "]";
    }
}
