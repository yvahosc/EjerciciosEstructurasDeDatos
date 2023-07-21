package co.com.MAKAIA.Ejercicio2OtraForma;

import java.util.Arrays;
import java.util.Scanner;

public class Juego {
    private int filasTablero = 4;
    private int columnasTablero = 4;
    private int intentosPermitidos = (int) (filasTablero * columnasTablero * 0.5);
    private int tamanhoBarcos = 2;
    private int cantidadBarcos = 3;
    private String[][] tablero;
    private String[][] tableroVisible;
    private static Juego juego;

    private Juego(){
        this.generarTablero();
        this.ubicarBarcos();
    }

    public static Juego getJuego(){
        if(juego == null){
            juego = new Juego();
        }
        return juego;
    }

    public void mostrarTableroDelJuego(){
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

    public void mostrarTableroVisible(){
        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible[i].length; j++) {
                if(j == 0){
                    System.out.print("|" + tableroVisible[i][j] + "|");
                } else{
                    System.out.print(tableroVisible[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    public void generarTablero(){
        tablero = new String[filasTablero][columnasTablero];
        tableroVisible = new String[filasTablero][columnasTablero];
        for (int i = 0; i < filasTablero; i++) {
            for (int j = 0; j < columnasTablero; j++) {
                tablero[i][j] = "-";
                tableroVisible[i][j] = "-";
            }
        }
    }

    public void ubicarBarcos(){
        int barcosVerticales = cantidadBarcos / 2;
        int barcosHorizontales = cantidadBarcos - barcosVerticales;

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

    public void jugar(){
        System.out.println("Tienes " + intentosPermitidos + " intentos para " +
                "destruir todos los barcos.");
        int intento = 0;
        boolean todosLosBarcosFueronDestruidos = estanTodosLosBarcosDestruidos();

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
                    tableroVisible[fila][columnas] = "*";
                    if (contenidoPosicion == "+") {
                        System.out.println("Objetivo alcanzado.");
                    }
                    posicionYaAtacada = true;
                    todosLosBarcosFueronDestruidos = estanTodosLosBarcosDestruidos();
                    intento++;
                    System.out.println("Tablero de ataques del jugador.");
                    this.mostrarTableroVisible();
                }
            }

        }
    }

    public boolean estanTodosLosBarcosDestruidos(){
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
