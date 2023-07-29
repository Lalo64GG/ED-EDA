import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random n = new Random();
        int [] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            int cant = n.nextInt(0, 100);
            array[i] = cant;
            System.out.println("Posicion " + "(" + (i+1) +") " + array[i]);
        }

        for (int i = 0; i< array.length - 1; i++) {
            for (int j = 0; j < array.length -1; j++) {
                if (array[j]>array[j+1]){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        System.out.println("Numeros ordenados");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Posicion " +"(" + (i+1) +") " + array[i]);
        }

    }
}