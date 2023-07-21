package co.com.MAKAIA.Ejercicio3;

public class Tarea {
    private String nombre;
    private String estado;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = "Pendiente";
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}
