package co.com.MAKAIA.Ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static Agenda agenda;
    private ArrayList<Contacto> listaDeContactos = new ArrayList<>();

    private Agenda(){}

    public static Agenda getAgenda(){
        if(agenda == null){
            agenda = new Agenda();
        }
        return agenda;
    }

    public void agregarContacto (){
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Ingrese el nombre del contacto:");
        String nombre = scannerString.nextLine();
        System.out.println("Ingrese el teléfono del contacto:");
        String telefono = scannerString.nextLine();
        Contacto contacto = new Contacto(nombre, telefono);
        listaDeContactos.add(contacto);
        System.out.println("El contacto " + contacto + " ha sido agregado a " +
                "la lista.");
    }

    public void buscarContactoPorNombre (){
        if(listaDeContactos.isEmpty()){
            System.out.println("La lista de contactos está vacía.");
        } else{
            Scanner scannerString = new Scanner(System.in);
            System.out.println("Ingrese el nombre del contacto a " +
                    "buscar:");
            String nombre = scannerString.nextLine();

            boolean contactoEncontrado = false;
            for (int i = 0; i < listaDeContactos.size(); i++) {
                if(listaDeContactos.get(i).getNombre().equals(nombre)){
                    System.out.println("El contacto buscado es: " +
                            listaDeContactos.get(i).toString() + ".");
                    contactoEncontrado = true;
                }
            }

            if(!contactoEncontrado){
                System.out.println("El nombre buscado no corresponde a ningún " +
                        "contacto de la lista.");
            }
        }
    }

    public void actualizarContacto (){
        if(listaDeContactos.isEmpty()){
            System.out.println("La lista de contactos está vacía.");
        } else{
            mostrarListaContactos();
            Scanner scannerString = new Scanner(System.in);
            int indiceContactoAActualizar = pedirIndiceDeLista();

            System.out.println(listaDeContactos.get(indiceContactoAActualizar).toString());
            System.out.println("Ingrese el nuevo nombre del contacto");
            listaDeContactos.get(indiceContactoAActualizar).setNombre(scannerString.nextLine());
            System.out.println("Ingrese el nuevo teléfono del contacto");
            listaDeContactos.get(indiceContactoAActualizar).setTelefono(scannerString.nextLine());
            System.out.println("Contacto actualizado:");
            System.out.println(listaDeContactos.get(indiceContactoAActualizar).toString());
        }
    }

    public void eliminarContacto (){
        if(listaDeContactos.isEmpty()){
            System.out.println("La lista de contactos está vacía.");
        } else{
            mostrarListaContactos();
            int indiceContactoAActualizar = pedirIndiceDeLista();
            listaDeContactos.remove(indiceContactoAActualizar);
            System.out.println("Contacto eliminado de la lista.");
        }
    }

    public void mostrarListaContactos(){
        if(listaDeContactos.size() == 0){
            System.out.println("La lista de contactos está vacía.");
        } else{
            for (int i = 0; i < listaDeContactos.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeContactos.get(i).toString());
            }
        }
    }

    public int pedirIndiceDeLista(){
        Scanner scannerint = new Scanner(System.in);
        boolean indiceValido = false;
        int indiceContactoAActualizar = 0;

        while(!indiceValido){
            System.out.println("Ingrese el número correspondiente al contacto:");
            indiceContactoAActualizar = scannerint.nextInt() - 1;

            if(indiceContactoAActualizar >= 0 &&
                    indiceContactoAActualizar < listaDeContactos.size()){
                indiceValido = true;
            } else{
                System.out.println("Ingrese un valor válido.");
            }
        }
        return indiceContactoAActualizar;
    }
}
