/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import modelo.ModuloGeneradorPlatillos;
import modelo.Platillos;
import vista.VistaMenu;

/**
 * Clase que permite agregar, eliminar o visualizar platillso existentes en el menu
 * @author Equipo_F
 */
public class ModuloCRUDPlatillos {
    
    /**
     * Método que permite al trabajador del restaurante a eliminar, agregar o visualizar algun platillos del menú, que por cuestiones de disponibilidad, haya sido borrado o esté de nuevo disponible, usando como parametro a la lista de platillos, para, una vez decidido que platillo agregar o eliminar, agregarlo a la lista de platillos.  
     * @param lista La lista de los platillos generados en un ArrayList
     * @throws IOException excepción en el método 
     */
    public void crearPlatillos(ArrayList<Platillos> lista) throws IOException{
        String [] matriz = {"Tacos", "Quesadillas","Sopes","Pozole","Tortas","Tlacoyos","Tostadas",
        "Tamales","Mole","Flautas","Pizza","Lasaña","Antipasti","Espagueti","Ravioles","Risotto","Ensalda Capresse",
        "Ossobuco","Tiramisu","Gelato","Sushi","Onigiri","Sashimi","Sopa miso","Udon","Ramen","Mochi","Takoyaky","Dango","Gohan"};
        int [] precio = {25,20,18,30,26,16,17,14,25,35,150,120,70,50,80,90,80,60,100,85,90,80,50,75,100,120,85,85,95,110};
        
        
        System.out.println("\n\t¿Qué desea realizar?\n");
        System.out.println("\tAgregar Platillo (1)");
        System.out.println("\tEliminar Platillo (2)");
        System.out.println("\tVisualizar Platillos (3)");
        
        Scanner opcionesCRUD = new Scanner (System.in);
        int opciones;  
        opciones = opcionesCRUD.nextInt();
        
        VistaMenu vistaMenu = new VistaMenu();
        vistaMenu.ControladorMenu2();
        if (opciones==1) {
           
            System.out.println("\n\t¿Qué platillo deseas crear?");
            Scanner crearPlatillo = new Scanner (System.in);
            int crea;
            crea = crearPlatillo.nextInt();
            
            Platillos platillo1 = new Platillos();
            platillo1.setNombre(matriz[crea-1]);
            platillo1.setPrecio(precio[crea-1]); 
            
            lista.add(platillo1);
            int b=1;
            for (Platillos platillos : lista) {
                System.out.println(b+")"+platillos);   
                b++;
            }
            
            System.out.println("\nSe agrego el platillo a la lista: "+platillo1.toString());
        }else if(opciones==2){
            
            int c=1;
            for (Platillos platillos : lista) {
                System.out.println(c+") "+platillos); 
                c++;
            }
            System.out.println("¿Que platillo deseas eliminar?");
            Scanner eliminarPlatillo = new Scanner (System.in);
            int eliminar;
            eliminar = eliminarPlatillo.nextInt();
            
            lista.remove(eliminar-1);
            }
        else if(opciones==3) {
             int b=1;
            for (Platillos platillos : lista) {
                System.out.println(b+") "+platillos); 
                b++;
            }
        }
        else{
            System.out.println("¡Opcion invalida!");
        }
        }  
    }