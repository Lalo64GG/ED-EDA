import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        do {
            System.out.println("Ingrese la opcion \n1.-Busqueda normal 2.-Busqueda con objetos");
             op = entrada.nextInt();
            switch (op){
                case 1:
                    HashMap<String, Integer> Persona = new HashMap<>();
                    Persona.put("Juan", 18);
                    Persona.put("Jorge", 15);
                    Persona.put("Pablo", 10);
                    System.out.println("Ingrese el nombre de la persona a buscar: ");
                    String busqueda = entrada.next();
                    if (Persona.containsKey(busqueda)){
                        int edad = Persona.get(busqueda);
                        System.out.println("La persona tiene la edad de: " + edad);
                    } else{
                        System.out.println("No se ha encontrado");
                    }
               break;

                case 2:
                    HashMap<String, Persona> tabla = new HashMap<>();
                    tabla.put("1234", new Persona(entrada.next(), entrada.next()));
                    tabla.put("5678", new Persona(entrada.next(), entrada.next()));
                    System.out.println("Ingrese el id de la persona a buscar: ");
                    String bus= entrada.next();
                    if (tabla.containsKey(bus)){
                        Persona persona = tabla.get(bus);
                        System.out.println("El nombre de la persona es: " + persona.getNombre() + " su edad es: " + persona.getEdad() + " años");
                    } else {
                        System.out.println("La persona no fue encontrada");
                    }

               break;

            }
        }while (op !=3);

    }
}