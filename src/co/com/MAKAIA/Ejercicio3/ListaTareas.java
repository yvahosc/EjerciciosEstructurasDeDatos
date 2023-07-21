package co.com.MAKAIA.Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaTareas {
    private static ListaTareas listaTareas;
    private ArrayList<Tarea> listaDeTareasPendientes = new ArrayList<>();
    private ArrayList<Tarea> listaDeTareasCompletadas = new ArrayList<>();

    private ListaTareas(){}

    public static ListaTareas getListaTareas(){
        if(listaTareas == null){
            listaTareas = new ListaTareas();
        }
        return listaTareas;
    }

    public void agregarTarea (){
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la tarea:");
        String nombre = scannerString.nextLine();
        Tarea tarea = new Tarea(nombre);
        listaDeTareasPendientes.add(tarea);
        System.out.println("La tarea " + tarea + " ha sido agregada a " +
                "la lista.");
    }

    public void mostrarListaTareasPendientes(){
        if(listaDeTareasPendientes.size() == 0){
            System.out.println("La lista de tareas pendientes está vacía.");
        } else{
            for (int i = 0; i < listaDeTareasPendientes.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeTareasPendientes.get(i).toString());
            }
        }
    }

    public void mostrarListaTareasCompletadas(){
        if(listaDeTareasCompletadas.size() == 0){
            System.out.println("La lista de tareas completadas está vacía.");
        } else{
            for (int i = 0; i < listaDeTareasCompletadas.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeTareasCompletadas.get(i).toString());
            }
        }
    }

    public void marcarTareaComoCompletada(){
        if(listaDeTareasPendientes.isEmpty()){
            System.out.println("La lista de tareas pendientes está vacía.");
        }else{
            mostrarListaTareasPendientes();
            int indice = pedirIndiceDeListaDeTareasPendientes();
            listaDeTareasPendientes.get(indice).setEstado("Completada");
            listaDeTareasCompletadas.add(listaDeTareasPendientes.get(indice));
            System.out.println("La tarea " + listaDeTareasPendientes.get(indice)
                    + " ha sido completada.");
            listaDeTareasPendientes.remove(indice);
        }
    }

    public int pedirIndiceDeListaDeTareasPendientes(){
        Scanner scannerint = new Scanner(System.in);
        boolean indiceValido = false;
        int indice = 0;

        while(!indiceValido){
            System.out.println("Ingrese el número correspondiente a la tarea:");
            indice = scannerint.nextInt() - 1;

            if(indice >= 0 &&
                    indice < listaDeTareasPendientes.size()){
                indiceValido = true;
            } else{
                System.out.println("Ingrese un valor válido.");
            }
        }
        return indice;
    }
}
