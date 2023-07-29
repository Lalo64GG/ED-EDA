import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int [] array = new int[10];
        Random n = new Random();
        for (int i = 0; i < array.length; i++) {
            int cant = n.nextInt(1, 100);
            while (cant == array[i]){
                cant = n.nextInt(0, 100) +1;
            }

            array[i] = cant;
        }

        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length -1; j++) {
                if (array[j]>array[j+1]){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }


        System.out.println("Arreglo ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posicion "+ i + " " + array[i]);
        }

        System.out.println("Ingrese el numero a buscar: ");
        int num = entrada.nextInt();
        int inferior = 0;
        int centro;
        int superior = array.length -1;
        while (inferior <= superior){
            centro = (superior + inferior)/2;
            if (array[centro] == num){
                System.out.println("El numero esta en la posicion: " + centro);
                break;
            } else if (num < array[centro]){
                superior = centro - 1;
            } else{
                inferior = centro + 1;
            }
        }

    }
}