/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author German Velasquez
 */
public class estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private int nota_promedio;

    public estudiante(String nombre, String apellido, int edad, int nota_promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nota_promedio = nota_promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNota_promedio() {
        return nota_promedio;
    }

    public void setNota_promedio(int nota_promedio) {
        this.nota_promedio = nota_promedio;
    }


}
