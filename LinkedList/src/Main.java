import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static LinkedList <Pasajero> lista;
    static  Pasajero x;

    public static void main(String[] args) {
        lista = convertirPasajeros("C:\\Users\\et059\\OneDrive\\Escritorio\\Pasajeros\\Pasajeros.txt");
        int op;
        do {
            System.out.println("Ingrese la opcion que desea\n 1.-Buscar 2.-Agregar nuevo pasajero 3.-Eliminar pasajero 4.-Imprimir 5.-Guardar Cambios 0.-Salir");
            op = entrada.nextInt();
            switch (op){
                case 1:
                    buscar();
                    break;
                case 2:
                    agregaPasajero();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    imprimir();
                    break;
                case 5:
                    guardarCambios("C:\\Users\\et059\\OneDrive\\Escritorio\\Pasajeros\\Pasajeros.txt", lista);
                    break;
            }
        } while(op !=0);
    }


    public static void agregaPasajero(){
        System.out.println("Ingrese el nombre del pasajero: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el número de asiento: ");
        String num = entrada.next();
        x = new Pasajero(nombre, num);
        lista.add(x);
    }

    public static void buscar() {
        boolean encontrado;
        int op;
        System.out.println("Buscar por: \n 1.-Nombre de pasajero 2.-Num. Asiento");
        op = entrada.nextInt();
        switch (op) {
            case 1:
                System.out.println("Ingrese el nombre del pasajero: ");
                String nombre = entrada.next();
                encontrado = false;
                for (Pasajero pasajero : lista) {
                    if (pasajero.getNombre().equals(nombre)) {
                        System.out.println("El pasajero se encuentra en la lista, el número de asiento es: " + pasajero.getNum());
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("La lista no contiene al pasajero");
                }
                break;
            case 2:
                System.out.println("Ingrese su numero de pasajero: ");
                String num = entrada.next();
                encontrado = false;
                for (Pasajero pasajero : lista) {
                    if (pasajero.getNum().equals(num)) {
                        System.out.println("El pasajero se encuentra en la lista, el nombre es: " + pasajero.getNombre());
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("La lista no contiene al pasajero");
                }
                    break;
                }
        }
    public static void eliminar(){
        System.out.println("Ingrese el número de asiento del pasajero: ");
        String num = entrada.next();
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            Pasajero pasajero = lista.get(i);
            if (pasajero.getNum().equals(num)) {
                System.out.println("Eliminando al pasajero...");
                lista.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El pasajero no se encuentra en la lista");
        }
    }

    public static void imprimir() {
        System.out.println("Ingrese la opcion que desea \n 1.-Imprimir del ultimo al primero 2.-Imprimir del primero al ultimo");
        int op = entrada.nextInt();
        switch (op) {
            case 1:
                Iterator<Pasajero> iterator = lista.descendingIterator();
                while (iterator.hasNext()) {
                    Pasajero pasajero = iterator.next();
                    System.out.println(pasajero);
                }
                break;

            case 2:
                Iterator<Pasajero> iterato = lista.iterator();
                while (iterato.hasNext()) {
                    Pasajero pasajero = iterato.next();
                    System.out.println(pasajero);
                }
                break;
        }
    }

    public static void guardarCambios(String archivo, LinkedList<Pasajero> pasajeros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            for (Pasajero pasajero : pasajeros) {
                String linea = pasajero.getNombre() + "-" + pasajero.getNum();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Pasajero> convertirPasajeros(String archivo) {
        LinkedList<Pasajero> pasajeros = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("-");

                Pasajero pasajero = new Pasajero(datos[0], datos[1]);

                pasajeros.add(pasajero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pasajeros;
    }
}

