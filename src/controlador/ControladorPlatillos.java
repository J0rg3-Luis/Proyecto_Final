/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



import java.io.IOException;
import java.util.ArrayList;
import modelo.Platillos;


/**
 * Clase elaborada auxiliar del modulo CRUD para remover un platillo
 * @author Equipo_F
 */
public class ControladorPlatillos {
    
    /**
     * Constructor vacío
     */
    public ControladorPlatillos() {
    }
    
    /**
     * Constructor que recibe una lista
     * @param lista La lista de los platillos generados en un ArrayList
     * @return La lista de los platillos generados en un ArrayList
     * @throws IOException excepción en el método 
     */
    public ArrayList controlPlatillos(ArrayList<Platillos> lista) throws IOException{
            int i=0;
            
            for (int j = 0; j <100 ; j++) {
                lista.remove(i);
            }
            /*for (Platillos platillos : lista) {
                System.out.println(platillos);
            }*/
            System.out.println("###################################################");
            return lista;
    }
}
