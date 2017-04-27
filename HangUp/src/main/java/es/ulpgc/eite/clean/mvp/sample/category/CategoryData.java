package es.ulpgc.eite.clean.mvp.sample.category;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class CategoryData {
    //private int imagen;
    private String nombre;
    private String descripcion;

    public CategoryData(String nombre, String descripcion) {
        //this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

//    public int getImagen() {
//        return imagen;
//    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

//Hacer un push
}
