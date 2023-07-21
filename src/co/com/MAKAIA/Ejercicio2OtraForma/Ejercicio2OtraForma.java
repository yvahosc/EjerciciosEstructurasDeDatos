package co.com.MAKAIA.Ejercicio2OtraForma;

public class Ejercicio2OtraForma {
    public static void main(String[] args) {
        Juego juego = Juego.getJuego();
        System.out.println("Tablero del juego.");
        juego.mostrarTableroDelJuego();
        System.out.println();

        juego.jugar();
        System.out.println();

        boolean juegoGanado = juego.estanTodosLosBarcosDestruidos();
        if(juegoGanado){
            System.out.println("Todos los barcos han sido derribados. " +
                    "Ganaste! =)");
        }else{
            System.out.println("Aún hay barcos sin derribar. Perdiste =(");
        }
        System.out.println("Tablero del juego.");
        juego.mostrarTableroDelJuego();
    }
}
