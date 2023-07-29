import java.util.ArrayList;

public class Grafo {
    private  ArrayList<Nodo> listaNodo;

    public void agregarNodo(Nodo nodo){
        if (listaNodo == null){
        listaNodo = new ArrayList<>();
        }
        listaNodo.add(nodo);
    }

    public ArrayList<Nodo> getListaNodo() {
        return listaNodo;
    }


    public int getCantidadNodos(){
        return listaNodo.size();
    }

    @Override
    public String toString() {
        return "Grafo{" +
                "listaNodo=" + listaNodo +
                '}';
    }
}



