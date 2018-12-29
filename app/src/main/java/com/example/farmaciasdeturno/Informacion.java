package com.example.farmaciasdeturno;


/*Clase donde se almacena los atributos correspondientes a una farmacia
* donde luego seran mostrados en el ListView. */

public class Informacion {

    private int id;
    private String nombre;
    private String horario;
    private String direccion;
    private int imagen;

    public Informacion(int id, String nombre, String horario, String direccion, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.direccion = direccion;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
