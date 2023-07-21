package co.com.MAKAIA.Ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[][] matriz1;
        int[][] matriz2;
        int[][] matrizSuma;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Suma de matrices cuadradas.");
        System.out.println("Ingrese el número de filas y columnas de la " +
                "primera matriz");
        int tamanhoMatriz1 = scanner.nextInt();

        System.out.println("Ingrese el número de filas y columnas de la " +
                "segunda matriz: ");
        int tamanhoMatriz2 = scanner.nextInt();

        if(tamanhoMatriz1 != tamanhoMatriz2){
            System.out.println("Las matrices no se pueden sumar.");
        }else{
            System.out.println("Ingrese los valores para la matriz 1:");
            matriz1 = llenarMatriz(tamanhoMatriz1);
            mostrarMatriz(matriz1);
            System.out.println();

            System.out.println("Ingrese los valores para la matriz 2:");
            matriz2 = llenarMatriz(tamanhoMatriz2);
            mostrarMatriz(matriz2);
            System.out.println();

            System.out.println("El resultado de la suma de las dos matrices " +
                    "es:");
            matrizSuma = sumarDosMatrices(matriz1, matriz2);
            mostrarMatriz(matrizSuma);
        }
    }

    public static int[][] llenarMatriz(int tamanho){
        int[][] matriz = new int[tamanho][tamanho];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.println("Ingrese el valor en la posicion (" + i + ", "
                        + j + "):");
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }

    public static int[][] sumarDosMatrices(int[][] matriz1, int[][] matriz2){
        int[][] matrizSuma = new int[matriz1.length][matriz1.length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1.length; j++) {
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return matrizSuma;
    }

    public static void mostrarMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
