import java.util.ArrayList;

public class Nodo {
    private String Dato;
    private ArrayList<Arista> lista;

    public Nodo(String dato) {
        Dato = dato;
    }

    public void setDato(String dato) {
        Dato = dato;
    }

    public String getDato() {
        return Dato;
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setAristas(Arista arista){
        if (lista == null){
             lista = new ArrayList<Arista>();
        }
        lista.add(arista);
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "Dato='" + Dato + '\'' +
                ", lista=" + lista +
                '}';
    }
}
