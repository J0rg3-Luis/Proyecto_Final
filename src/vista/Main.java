/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorMenu;
import controlador.ControladorPlatillos;
import controlador.ModuloCRUDPlatillos;
import controlador.ModuloImBaseDatos;
import controlador.PedidosCliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModuloGeneradorPlatillos;
import modelo.ModuloPedidos;
import modelo.PedidosListos;
import modelo.Platillos;

/**
 * Clase diseñada para que el operardor (trabajador del restaurante), maneje distintas funciones de restaurante.
 * Desde aqui puede hacer la eliminacion de algun platillo, hacer una compra manual para un cliente, etc.
 * @author Equipo_F
 */
public class Main {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args)   {
        
        ArrayList<String> miArrayListMenuRemoveMexicano = new ArrayList<String>();
        ArrayList<String> miArrayListMenuRemoveItaliano = new ArrayList<String>();
        ArrayList<String> miArrayListMenuRemoveJapones = new ArrayList<String>();
        ArrayList<String> miArrayListMenuMexicano = new ArrayList<String>();
        ArrayList<String> miArrayListMenuItaliano = new ArrayList<String>();
        ArrayList<String> miArrayListMenuJapones = new ArrayList<String>();
        
        ArrayList<Platillos> lista = new ArrayList<Platillos>();
        ArrayList<String> ventasDelDia = new ArrayList<String>();
        

        ModuloGeneradorPlatillos generadorPlatillos = new ModuloGeneradorPlatillos();
        generadorPlatillos.generandoPlatillos(lista);
        
        ControladorPlatillos controladorPlatillos= new ControladorPlatillos();
                    
        try {
            
            lista = controladorPlatillos.controlPlatillos(lista);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModuloPedidos mp1= new ModuloPedidos();
        mp1.pedidos();
        
        PedidosListos pl=new PedidosListos();
        pl.listaPedidosListo();
        ModuloImBaseDatos mid=new ModuloImBaseDatos();   
        mid.archivoVentas();
        mid.archivoPedidosListos();
        int numCliente=0;
        int salidaRestaurante=0;
        int contMenu=0;
        int listaPedido=0;
        
        do{
            System.out.println("\n¡Bienvenido al Restaurante de Especialidades!");
            System.out.println("\t\tEquipo F");
            System.out.println("\n\t| ¿Qué se le ofrece? |\n");
            System.out.println("° Menú (1)");
            System.out.println("° Módulo generador de objetos platillo (2)");
            System.out.println("° Módulo generador de pedidos (3)");
            System.out.println("° Módulo CRUD platillos (4)");
            System.out.println("° Comprar (5)");
            System.out.println("° Modulo impresión base de datos (6)");
            System.out.println("° Salir del restaurante (7)");
            Scanner proyectoRestaurante = new Scanner(System.in);
            int opcionesRestaurante; 
            opcionesRestaurante = proyectoRestaurante.nextInt();

            switch (opcionesRestaurante){
                
                case 1: 
                    ControladorMenu controladorMenu = new ControladorMenu();
                    controladorMenu.ConfigurarMenu(miArrayListMenuMexicano, miArrayListMenuItaliano, miArrayListMenuJapones, 
                    miArrayListMenuRemoveMexicano, miArrayListMenuRemoveItaliano, miArrayListMenuRemoveJapones, contMenu);
                    contMenu=1;
                    break;
                    
                case 2:
                    ModuloGeneradorPlatillos generadorPlatillos2 = new ModuloGeneradorPlatillos();
                    generadorPlatillos2.mostrarPlatillos();
                    break;
                    
                case 3: 
                    ModuloPedidos pedidosclien=new ModuloPedidos();
                    pedidosclien.mostrarpedidos();
                    break;
                    
                case 4:
                    ModuloCRUDPlatillos moduloCRUDPlatillos= new ModuloCRUDPlatillos();
                    {
                    try {
                        moduloCRUDPlatillos.crearPlatillos(lista);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    break;

                
                case 5:
                    numCliente++;
                    PedidosCliente mp =new PedidosCliente();
                    mp.buscarPedidos(lista);
                    System.out.println("¡¡¡¡¡ORDEN LISTA!!!!!!");
                    mp.generarTicket(numCliente,listaPedido, ventasDelDia);
                    System.out.println("Vuelva pronto!!!!!");
                    break;
                case 6:
                    ModuloImBaseDatos mid1=new ModuloImBaseDatos();
                    
                    mid1.mostrarVentas();
                    mid1.mostrarPedidosListos();

                    break;


                case 7:
                    System.out.println("Saliendo del Restaurante...");
                    salidaRestaurante=1;
                    break;
            }   
        }while (salidaRestaurante == 0);
                
    }
}
