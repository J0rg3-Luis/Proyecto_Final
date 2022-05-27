/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *Clase responsable de asignar una estructura general a los pedidos que sean creados por el modulo generador de pedidos.
 * @author Equipo_F
 */
public class Pedidos {
    private String nomPlatillo;
    private float precio;
    private String tipoEnvoltura;
    private String cubiertos;
    
    /**
     * Constructor vacío 
     */
    
    public Pedidos() {
    }
    
   
    public String getNomPlatillo() {
        return nomPlatillo;
    }

    public void setNomPlatillo(String nomPlatillo) {
        this.nomPlatillo = nomPlatillo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipoEnvoltura() {
        return tipoEnvoltura;
    }

    public void setTipoEnvoltura(String tipoEnvoltura) {
        this.tipoEnvoltura = tipoEnvoltura;
    }

    public String getCubiertos() {
        return cubiertos;
    }

    public void setCubiertos(String cubiertos) {
        this.cubiertos = cubiertos;
    }
    
    /**
     * Método que imprime el nombre, precio, tipo de envoltura del empaquetado y si tendrá cubiertos o no de un pedido
     * @return El nomPlatillo, precio, tipoEnvoltura, cubiertos de un pedido
     */
    
    public String mostrarPedido(){
        return nomPlatillo+"....$"+precio+"\tEmpacado["+tipoEnvoltura + "--" + cubiertos+"]";
    }
    /**
     * Método que imprime el nombre, precio, tipo de envoltura del empaquetado y si tendrá cubiertos o no de un pedido vendido
     * @return El nomPlatillo, precio, tipoEnvoltura, cubiertos de un pedido vendido
     */
    
    public String pedidoVendido(){
        return "Platillo: "+nomPlatillo+"....Precio:$"+precio+" \tTipo envoltura: "+tipoEnvoltura + "\tCubiertos:" + cubiertos;
    }
    
    /**
     * Método que imprime el nombre, precio, tipo de envoltura del empaquetado y si tendrá cubiertos o no de un pedido separado por comas
     * @return El nomPlatillo, precio, tipoEnvoltura, cubiertos de un pedido 
     */
    
    @Override
    public String toString() {
        return  nomPlatillo + "," + precio + "," + tipoEnvoltura + "," + cubiertos;
    }
    

}
