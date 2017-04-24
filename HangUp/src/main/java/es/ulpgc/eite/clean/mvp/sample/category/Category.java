package es.ulpgc.eite.clean.mvp.sample.category;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class Category {
    private int imagen;
    private String nombre;
    private String descripcion;

    public Category(int imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int  getImagen() {
        return imagen;
    }
}
