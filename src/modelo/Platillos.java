/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase correspondiente a la estructura que llevan los platillos que serán almacenados en la Base de datos de los platillos. Estos platillos tendrán como atributos su nombre y precio indistintamente de la especialidad.
 * @author Equipo_F
 */
public class Platillos {
    
    private String nombre;
    private float precio;
    
    /**
     * Constructor vácio
     */
    public Platillos() {
    }
    
    /**
     * Constructor que nombre y precio 
     * @param string El nombre del platillo 
     * @param i El precio del platillo
     */
    
    public Platillos(String string, int i) {
        
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    /**
     * Método que imprime el nombre y precio de un platillo separada por puntos
     * @return El nombre y precio de un platillo
     */
    
    public String mostrarPlatillo(){
        return nombre + "........$" + precio ;
    }
    
    /**
     * Método que imprime el nombre y precio de un platillo separada por comas
     * @return El nombre y precio de un platillo
     */
    
    @Override
    public String toString() {
        return   nombre + "," + precio;
    }
    
    
}
