import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        Grafo grafo = null;
        do {
            System.out.println("Seleccione la opcion deseada: \n1.- Crear grafo 2.- Mostrar grafo 3.- Mostrar la cantidad de nodos en el grafo 4.- Recorrido en profundidad 5.-Busqueda del nodo 0.- Salir");
            op = entrada.nextInt();
            switch (op){
                case 1:
                    grafo = crearGrafo();
                    break;
                case 2:
                    System.out.println(grafo);
                    break;
                case 3:
                    System.out.println("Cantidad de nodos: " + grafo.getCantidadNodos());
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Ingrese el valor del nodo: ");
                    String buscar = entrada.next();
                    if (busquedaNodo(grafo, buscar) == -1) {
                        System.out.println("Nodo no encontrado");
                    } else {
                        System.out.println("La posicion del nodo es: " + busquedaNodo(grafo, buscar) );
                    }
                    break;
            }
        }while(op != 0);
    }

    public static Grafo crearGrafo(){
        ArrayList<Nodo> listaNodo = new ArrayList<Nodo>();
        int cantidad;
        int op;
        String valorNodo;

        System.out.println("Ingresar la cantidad de nodos a agregrar: ");
            cantidad = entrada.nextInt();
        for (int i = 0; i < cantidad; i++) {

            System.out.println("Ingrese el valor del nodo: ");
            valorNodo = entrada.next();
            Nodo nodo = new Nodo(valorNodo);
            listaNodo.add(nodo);
        }
        System.out.println("\n2.- Lista de adyacencia");
        do {
            System.out.println("Desea crear conexion? \n1.- Si 2.-No");
            op = entrada.nextInt();
            if (op == 1){
                crearConexion(listaNodo, cantidad);
            }
        }while(op == 1 );

        Grafo grafo = new Grafo();
        for (int i = 0; i < listaNodo.size(); i++) {
            Nodo temp = listaNodo.get(i);
            grafo.agregarNodo(temp);
        }

        return grafo;
    }

    public static void crearConexion( ArrayList<Nodo> listaNodo, int cantidad ){
        String valorNodo, nodoFinTemp;
        Nodo nodoInicio, nodoFin;
        boolean bandera = false;

        do {
            System.out.println("Digite el nodo inicio ");
            valorNodo = entrada.next();
            nodoInicio = busqueda(listaNodo, valorNodo);
            if (nodoInicio == null){
                System.out.println("Valor no encontrado");
            } else{
                do {
                    System.out.println("Ingrese el valor de nodo queb esta conectado");
                    nodoFinTemp = entrada.next();
                    nodoFin = busqueda( listaNodo, nodoFinTemp );
                    if (nodoFin == null){
                        System.out.println("Valor no encontrado");
                    } else{
                        System.out.println("Ingrese el peso");
                        nodoInicio.setAristas(new Arista(nodoInicio, nodoFin, entrada.nextDouble()));
                        System.out.println("Conexion Establecida");
                        bandera = true;
                    }
                }while(nodoFin == null);
            }
        }while(bandera == false);

    }

    public static Nodo busqueda(ArrayList<Nodo> listaNodo, String valorBuscado){
        Nodo nodoInicio = null;
        for (int i = 0; i < listaNodo.size(); i++) {
            Nodo temporal = listaNodo.get(i);
            if (temporal.getDato().equals(valorBuscado)){
                nodoInicio = temporal;
                return nodoInicio;
            }
        }
        return null;
    }

    public static int busquedaNodo(Grafo grafo, String valorBuscado){
        int posicion = -1;
        ArrayList<Nodo> listaNodo = grafo.getListaNodo();
        for (int i = 0; i < listaNodo.size(); i++) {
            Nodo nodoTemp = listaNodo.get(i);
            if (nodoTemp.getDato().equals(valorBuscado)) {
                posicion = i;
            }
        }
        return posicion;
    }
}