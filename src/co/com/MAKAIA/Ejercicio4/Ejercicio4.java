package co.com.MAKAIA.Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        boolean programaEnEjecucion = true;
        Scanner scannerint = new Scanner(System.in);
        Agenda agenda = Agenda.getAgenda();

        while(programaEnEjecucion){
            mostrarMenu();
            int opcionMenu = scannerint.nextInt();
            switch (opcionMenu){
                case 1:
                    agenda.agregarContacto();
                break;
                case 2:
                    agenda.buscarContactoPorNombre();
                break;
                case 3:
                    agenda.actualizarContacto();
                break;
                case 4:
                    agenda.eliminarContacto();
                break;
                case 5:
                    agenda.mostrarListaContactos();
                break;
                case 6:
                    programaEnEjecucion = false;
                    System.out.println("Programa finalizado.");
                break;
                default:
                    System.out.println("Ingrese un valor válido.");
            }

        }
    }

    public static void mostrarMenu(){
        System.out.println("\nAgenda de contactos.");
        System.out.println("1. Agregar un contacto a la lista.");
        System.out.println("2. Buscar un contacto por su nombre.");
        System.out.println("3. Actualizar la información de un contacto.");
        System.out.println("4. Eliminar un contacto de la lista.");
        System.out.println("5. Mostrar todos los contactos.");
        System.out.println("6. Salir del programa.");
        System.out.println("Ingrese número de acción que desea realizar:");
    }
}
