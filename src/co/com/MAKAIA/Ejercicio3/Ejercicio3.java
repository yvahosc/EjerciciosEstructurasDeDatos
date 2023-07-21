package co.com.MAKAIA.Ejercicio3;

import co.com.MAKAIA.Ejercicio4.Agenda;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        boolean programaEnEjecucion = true;
        Scanner scannerint = new Scanner(System.in);
        ListaTareas tareas = ListaTareas.getListaTareas();

        while(programaEnEjecucion){
            mostrarMenu();
            int opcionMenu = scannerint.nextInt();
            switch (opcionMenu){
                case 1:
                    tareas.agregarTarea();
                    break;
                case 2:
                    tareas.marcarTareaComoCompletada();
                    break;
                case 3:
                    tareas.mostrarListaTareasPendientes();
                    break;
                case 4:
                    tareas.mostrarListaTareasCompletadas();
                    break;
                case 5:
                    programaEnEjecucion = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Ingrese un valor válido.");
            }

        }
    }

    public static void mostrarMenu(){
        System.out.println("\nLista de tareas");
        System.out.println("1. Agregar una tarea a la lista.");
        System.out.println("2. Marcar una tarea como completada.");
        System.out.println("3. Mostrar todas las tareas pendientes.");
        System.out.println("4. Mostrar todas las tareas completadas.");
        System.out.println("5. Salir del programa.");
        System.out.println("Ingrese número de acción que desea realizar:");
    }
}
