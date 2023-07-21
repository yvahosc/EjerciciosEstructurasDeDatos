package co.com.MAKAIA.Ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int filasTablero = 4;
        int columnasTablero = 4;
        int intentos = (int) (filasTablero * columnasTablero * 0.5);
        int tamanhoBarcos = 2;
        int cantidadBarcos = 3;

        String[][] tablero = generarTablero(filasTablero, columnasTablero);
        mostrarTablero(tablero);
        System.out.println();

        ubicarBarcos(tablero, tamanhoBarcos, cantidadBarcos);
        mostrarTablero(tablero);
        System.out.println();

        ataque(intentos, tablero);
        mostrarTablero(tablero);
        System.out.println();

        boolean juegoGanado = estanTodosLosBarcosDestruidos(tablero);
        if(juegoGanado){
            System.out.println("Todos los barcos han sido derribados. Ganaste!");
        }else{
            System.out.println("Aún hay barcos en pie. Perdiste!");
        }
        mostrarTablero(tablero);
    }

    public static String[][] generarTablero(int filasTablero, int columnasTablero){
        String[][] tablero = new String[filasTablero][columnasTablero];
        for (int i = 0; i < filasTablero; i++) {
            for (int j = 0; j < columnasTablero; j++) {
                tablero[i][j] = "-";
            }
        }
        return tablero;
    }

    public static void mostrarTablero(String[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(j == 0){
                    System.out.print("|" + tablero[i][j] + "|");
                } else{
                    System.out.print(tablero[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    public static void ubicarBarcos(String[][] tablero, int tamanhoBarcos,
                                    int cantidadBarcos){
        int barcosVerticales = cantidadBarcos / 2;
        int barcosHorizontales = cantidadBarcos - barcosVerticales;
        System.out.println(barcosVerticales);
        System.out.println(barcosHorizontales);

        //Construcción barcos verticales
        for (int i = 0; i < barcosVerticales; i++) {
            int columna =
                    (int) (Math.random() * (tablero[0].length - tamanhoBarcos + 1));
            int fila =
                    (int) (Math.random() * (tablero.length - tamanhoBarcos + 1));
            String barco = "";

            for (int j = 0; j < tamanhoBarcos; j++) {
                barco = barco + tablero[fila + j][columna];
            }

            if(!barco.contains("+")){
                for (int j = 0; j < tamanhoBarcos; j++) {
                    tablero[fila + j][columna] = "+";
                }
            }else{
                i = i - 1;
            }
        }

        //Construcción barcos horizontales
        for (int i = 0; i < barcosHorizontales; i++) {
            int columna =
                    (int) (Math.random() * (tablero[0].length - tamanhoBarcos + 1));
            int fila =
                    (int) (Math.random() * (tablero.length - tamanhoBarcos + 1));
            String barco = "";

            for (int j = 0; j < tamanhoBarcos; j++) {
                barco = barco + tablero[fila][columna + j];
            }

            if(!barco.contains("+")){
                for (int j = 0; j < tamanhoBarcos; j++) {
                    tablero[fila][columna + j] = "+";
                }
            } else{
                i = i - 1;
            }
        }
    }

    public static int pedirCoordenada(int tamanhoRestriccion,
                                      String tipoCoordenada){
        boolean coordenadaValida = false;
        int coordenada = 0;
        Scanner scannerint = new Scanner(System.in);

        while(!coordenadaValida){
            System.out.println("Ingrese la coordenada para la " + tipoCoordenada
                    + " a atacar:");
            coordenada = scannerint.nextInt();
            if(coordenada >= 0 && coordenada < tamanhoRestriccion){
                coordenadaValida = true;
            }else{
                System.out.println("Ingrese un valor válido. Entre los " +
                        "límites del tablero.");
            }
        }
        return coordenada;
    }

    public static void ataque(int intentosPermitidos, String[][] tablero){
        int intento = 0;
        boolean todosLosBarcosFueronDestruidos = estanTodosLosBarcosDestruidos(tablero);

        while(intento < intentosPermitidos && !todosLosBarcosFueronDestruidos){
            boolean posicionYaAtacada = false;
            while(!posicionYaAtacada) {
                System.out.println("\nIntento " + (intento + 1) + ".");
                int fila = pedirCoordenada(tablero.length, "fila");
                int columnas = pedirCoordenada(tablero[0].length, "columna");
                String contenidoPosicion = tablero[fila][columnas];
                if (contenidoPosicion == "*") {
                    System.out.println("Posición ya atacada.");
                } else {
                    tablero[fila][columnas] = "*";
                    if (contenidoPosicion == "+") {
                        System.out.println("Objetivo alcanzado.");
                    }
                    posicionYaAtacada = true;
                    todosLosBarcosFueronDestruidos = estanTodosLosBarcosDestruidos(tablero);
                    intento++;
                }
            }

        }
    }

    public static boolean estanTodosLosBarcosDestruidos(String[][] tablero){
        boolean todosLosBarcosFueronDestruidos = true;
        for (int i = 0; i < tablero.length; i++) {
            boolean filaTableroFinal = Arrays.asList(tablero[i]).contains("+");
            if(filaTableroFinal){
                todosLosBarcosFueronDestruidos = false;
                break;
            }
        }
        return todosLosBarcosFueronDestruidos;
    }
}
