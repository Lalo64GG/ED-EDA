import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.nanoTime();
        System.out.println("-------------------------------------------------------------");
        Random n = new Random();
        int [] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            int cant = n.nextInt(1000000, 9999999);
            while (cant == array[i]){
                cant = n.nextInt(1000000, 9999999) + 1;
            }
             array[i] = cant;
        }



        for (int i = 0; i < array.length; i++) {
            System.out.println("961" + array[i]);
        }

        long tiempo1 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int j = i -1;
            while(j >=0 && array[j] > num){
                array[j + 1] = array[j];
                j--;
            }
             array[j+1] = num;

        }
        long tiempo2 = System.nanoTime();

        System.out.println("---------------------------------------------\n---------------------------------------------");

        for (int i = 0; i < array.length; i++) {
            System.out.println("961" + array[i]);
        }

        System.out.println("Ordenamiento burbuja");

        int [] array1 = new int[10];
        array1 = array;

        long tiempo3 = System.nanoTime();
        for (int i = 0; i< array1.length - 1; i++) {
            for (int j = 0; j < array1.length -1; j++) {
                if (array[j]>array1[j+1]){
                    int aux = array1[j];
                    array1[j] = array1[j+1];
                    array1[j+1] = aux;
                }
            }
        }

        for (int i = 0; i < array1.length; i++) {
            System.out.println("961"+array1[i]);
        }

        long tiempo4 = System.nanoTime();

        long diferencia = tiempo2 - tiempo4;
        diferencia *=-1;
        if (tiempo2 < tiempo4){
            System.out.println("El ganador fue ordenamiento por insercion el tiempo fue de: " + tiempo2 + "  con una diferencia de: " + diferencia);
        } else{
            System.out.println("El ganador fue ordenamiento burbuja" + tiempo4 + " con una diferencia de: " + diferencia);
        }


    }
}