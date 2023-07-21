package co.com.MAKAIA.Ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Integer> listaNumerosEnteros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numeroMaximo = 0;

        System.out.println("Número mas grande de una lista.");
        System.out.println("Ingrese la cantidad de números que va a tener la " +
                "lista:");
        int cantidadNumeros = scanner.nextInt();

        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.println("Ingrese el valor correspondiente al número "
                    + (i + 1) + ":");
            listaNumerosEnteros.add(scanner.nextInt());
        }

        for (int i = 0; i < cantidadNumeros; i++) {
            if(i == 0){
                numeroMaximo = listaNumerosEnteros.get(i);
            } else{
                if (listaNumerosEnteros.get(i) > numeroMaximo){
                    numeroMaximo = listaNumerosEnteros.get(i);
                }
            }
        }

        System.out.println("El número mayor de la lista es: " + numeroMaximo + ".");
    }
}
