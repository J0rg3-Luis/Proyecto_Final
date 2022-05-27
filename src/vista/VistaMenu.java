/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
/**
 *Clase generada para visualizar el Menu del restaruante, Dividido segun las especialidades de cada país, y dando opcion de visualizar el numero de platillo que es.
 * @author Equipo_F
 */
public class VistaMenu {
    
    /**
     * Método que asigna en un arreglo llamado "vistaMenu2", todos los platillos con su precio, en forma de cadena, para posteriormente, implementar un ciclo for para dividir las impresiones de cada especialidad, hasta donde corresponde la misma.
     * 
     */
    public void ControladorMenu2(){
    String [] vistaMenu2 = {"1) Tacos: $25", "2) Quesadillas: $20","3) Sopes: $18","4) Pozole: $30","5) Tortas: $26","6) Tlacoyos: $16",
            "7) Tostadas: $17","8) Tamales: $14","9) Mole: $25","10) Flautas: $35","11) Pizza: $150","12) Lasaña: $120","13) Antipasti: $70",
            "14) Espagueti: $50","15) Ravioles: $80","16) Risotto: $90","17) Ensalda Capresse: $80","18) Ossobuco: $60","19) Tiramisu: $100",
            "20) Gelato: $85","21) Sushi: $90","22) Onigiri: $80","23) Sashimi: $50","24) Sopa miso: $75","25) Udon: $100","26) Ramen: $120",
            "27) Mochi: $85","28) Takoyaky: $85","29) Dango: $95","30) Gohan: $110"};  
    
    System.out.println("\n\n############# Especialidad Mexicana #############\n");
        System.out.println("\t\t|Platillos|Precio|\n");
        for (int a=0; a<10; a++){
            System.out.println("\t\t"+vistaMenu2[a]); 
        }   
        
        System.out.println("\n\n############# Especialidad Italiana #############\n");
        System.out.println("\t\t|Platillos|Precio|\n");
        for (int b=10; b<20; b++){
            System.out.println("\t\t"+vistaMenu2[b]);  
        }
        
        System.out.println("\n\n############# Especialidad Japonesa #############\n");
        System.out.println("\t\t|Platillos|Precio|\n");
        for (int c=20; c<30; c++){
             System.out.println("\t\t"+vistaMenu2[c]);  
        }       
}
}
