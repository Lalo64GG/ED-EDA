import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static HashMap<String, Alumno> lista = new HashMap<String, Alumno>();
    public static void main(String[] args) {
        int op;
        do {
            System.out.println("Ingrese la opcion \n1.- Agregar 2.-Buscar 3.-Imprimir lista 0.-Salir");
            op = entrada.nextInt();
            switch (op){
                case 1:
                    generarAlumno();
                    break;
                case 2:
                    if (!lista.isEmpty()){
                    System.out.println("Ingrese la matricula a buscar: ");
                    String bus = entrada.next();
                    if (lista.containsKey(bus)) {
                        Alumno a = lista.get(bus);
                        System.out.println("El nombre: " + a.getNombre() + " Apellido: " + a.getApellido() + " Carrera: " + a.getCarrera()+" Cuatrimestre: " + a.getCuatrimestre());
                    } else {
                        System.out.println("El articulo no fue encontrada");
                    }
            } else{
                System.out.println("La lista esta vacía");
            }
                    break;
                case 3:
                    if (!lista.isEmpty()){
                        for (Map.Entry<String, Alumno> b : lista.entrySet()) {
                            String clave = (b.getKey());
                            Alumno dato = b.getValue();
                            System.out.println("Matricula: " +clave + ", " + dato.toString());
                        }
                    } else{
                        System.out.println("La lista esta vacía");
                    }
                    break;
            }

        }while(op != 0);
    }

    public static void generarAlumno(){
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese su apellido: ");
        String apellido = entrada.next();
        System.out.println("Ingrese su matricula: ");
        String matricula = entrada.next();
        while (matricula.length() != 5){
            System.out.println("Ingrese de nuevo");
            matricula = entrada.next();
        }
        System.out.println("Ingrese el nombre de su carrera: ");
        String carrera = entrada.next();
        System.out.println("Ingrese su cuatrimestre: ");
        String cuatrimestre = entrada.next();
        Alumno alumno = new Alumno(nombre, apellido, carrera, cuatrimestre);
        //lista.put(matricula, alumno);
        while (lista.containsKey(matricula)) {
            System.out.println("La lista ya contiene esta persona\n Ingrese su matricula ");
            matricula = entrada.next();
        }
            lista.put(matricula, alumno);
    }
}