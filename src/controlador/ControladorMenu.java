/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Clase responsable del funcionamiento de todas las acciones relacionadas al menu, en esta clase es posible eliminar o crear platillos que esten, o no, en el inventario de platillos. Esta clase es de uso exclusivo para los empleados del restaurante
 * @author Equipo_F
 */
public class ControladorMenu {
    
    /**
     * Metodo que utiliza como parametro 3 arreglos de cadenas, correspondientes a cada seccion de especialidades del menú, aparte de la posición del platillo deaseada a remover del menu. 
     * @param miArrayListMenuMexicano La lista de los platillos mexicanos generados en un ArrayList
     * @param miArrayListMenuItaliano La lista de los platillos italianos generados en un ArrayList
     * @param miArrayListMenuJapones La lista de los platillos japoneses generados en un ArrayList
     * @param miArrayListMenuRemoveMexicano La lista de los platillos mexicanos eliminados y generados en un ArrayList
     * @param miArrayListMenuRemoveItaliano La lista de los platillos italianos eliminados y generados en un ArrayList
     * @param miArrayListMenuRemoveJapones La lista de los platillos japoneses eliminados y generados en un ArrayList
     * @param contMenuConfigurar 
     */
    public void ConfigurarMenu(ArrayList<String> miArrayListMenuMexicano, ArrayList<String> miArrayListMenuItaliano,
            ArrayList<String> miArrayListMenuJapones, ArrayList<String> miArrayListMenuRemoveMexicano, 
            ArrayList<String> miArrayListMenuRemoveItaliano, ArrayList<String> miArrayListMenuRemoveJapones, int contMenuConfigurar){
        
        String [] vistaMenuMexicano = {"Tacos: $25", "Quesadillas: $20","Sopes: $18","Pozole: $30","Tortas: $26","Tlacoyos: $16",
            "Tostadas: $17","Tamales: $14","Mole: $25","Flautas: $35"};
        
        String [] vistaMenuItaliano = {"Pizza: $150","Lasaña: $120","Antipasti: $70","Espagueti: $50","Ravioles: $80","Risotto: $90",
            "7) Ensalda Capresse: $80","8) Ossobuco: $60","9) Tiramisu: $100","10) Gelato: $85"};
        
        String [] vistaMenuJapones = {"Sushi: $90","Onigiri: $80","Sashimi: $50","Sopa miso: $75","Udon: $100","Ramen: $120",
            "Mochi: $85","Takoyaky: $85","Dango: $95","Gohan: $110"};  
        
        if (contMenuConfigurar==0){
            for (int a=0; a<vistaMenuMexicano.length; a++){
                miArrayListMenuMexicano.add(vistaMenuMexicano[a]);
            }

            for (int b=0; b<vistaMenuItaliano.length; b++){
                miArrayListMenuItaliano.add(vistaMenuItaliano[b]); 
            }

            for (int c=0; c<vistaMenuJapones.length; c++){
                miArrayListMenuJapones.add(vistaMenuJapones[c]);
            }
        }
        
        int salidaMenu=0;
        
         do{        
            System.out.println("\n\n\t| Confuguración Menú |");
            System.out.println("\n\t ° Visualizar el menú(1):");
            System.out.println("\t ° Modificar el Menú(2):");
            System.out.println("\t ° Salir del Menú(3):");
            Scanner opciones = new Scanner(System.in);
            int numero; 
            numero = opciones.nextInt();

            switch (numero){
                case 1:
                    System.out.println("\n\n############# Especialidad Mexicana #############\n");
                    System.out.println("\t\t|Platillos|Precio|\n");
                    int contMex=1;
                    for (String listaMenuMexicano : miArrayListMenuMexicano) {
                        System.out.println("\t\t"+contMex+") "+listaMenuMexicano);
                        contMex++;
                    }

                    System.out.println("\n\n############# Especialidad Italiana #############\n");
                    System.out.println("\t\t|Platillos|Precio|\n");
                    int contIta=1;
                    for (String listaMenuItaliano : miArrayListMenuItaliano) {
                        System.out.println("\t\t"+contIta+") "+listaMenuItaliano);
                        contIta++;
                    }
                    int contJap=1;
                    System.out.println("\n\n############# Especialidad Japonesa #############\n");
                    System.out.println("\t\t|Platillos|Precio|\n"); 
                    for (String listaMenuJapones : miArrayListMenuJapones) {
                        System.out.println("\t\t"+contJap+") "+listaMenuJapones);
                        contJap++;
                    }
                    break;

                case 2:  
                    System.out.println("\n\t Agregar algún platillo del menú(1):");
                    System.out.println("\t Eliminar algún platillo del menú(2):");
                    Scanner eliminarAgregar = new Scanner(System.in);
                    int elimagre;
                    elimagre = eliminarAgregar.nextInt();
                    switch (elimagre){
                        case 1:
                            System.out.println("\n\n¿De qué especialidad deseas agregar?\n"); 
                            System.out.println("\n\t°Especialidad Mexicana (1)\n\t°Especialidad Italiana (2)\n\t°Especialidad Japonesa (3)\n"); 

                            Scanner agregarEspecialidad = new Scanner(System.in);
                            int agregarPlatillo;
                            agregarPlatillo = agregarEspecialidad.nextInt();
                            switch (agregarPlatillo){
                                case 1:
                                    Scanner agregarMexicano = new Scanner(System.in);
                                    int platilloMexicano;
                                    
                                    int a=1;
                                    for (String listaRemoveMex : miArrayListMenuRemoveMexicano) {
                                        System.out.println(a+") "+listaRemoveMex);
                                        a++;
                                    }
                                    
                                    System.out.println("¿Qué platillo ya se encuentra disponible nuevamente?: ");
                                    platilloMexicano = agregarMexicano.nextInt();
                                    miArrayListMenuMexicano.add(miArrayListMenuRemoveMexicano.get(platilloMexicano-1));
                                    miArrayListMenuRemoveMexicano.remove(platilloMexicano-1);
                                    
                                    break;

                                case 2:
                                    Scanner agregarItaliano = new Scanner(System.in);
                                    int platilloItaliano;
                                    
                                    int b=1;
                                    for (String listaRemoveIta : miArrayListMenuRemoveItaliano) {
                                        System.out.println(b+") "+listaRemoveIta);
                                        b++;
                                    }
                                    
                                    System.out.println("¿Qué platillo ya se encuentra disponible nuevamente?: ");
                                    platilloItaliano = agregarItaliano.nextInt();
                                    miArrayListMenuItaliano.add(miArrayListMenuRemoveItaliano.get(platilloItaliano-1));
                                    miArrayListMenuRemoveItaliano.remove(platilloItaliano-1);
                                    break;

                                case 3:
                                    Scanner agregarJapones = new Scanner(System.in);
                                    int platilloJapones;
                                    
                                    int c=1;
                                    for (String listaRemoveJap : miArrayListMenuRemoveJapones) {
                                        System.out.println(c+") "+listaRemoveJap);
                                        c++;
                                    }
                                    
                                    System.out.println("¿Qué platillo ya se encuentra disponible nuevamente?: ");
                                    platilloJapones = agregarJapones.nextInt();
                                    miArrayListMenuJapones.add(miArrayListMenuRemoveJapones.get(platilloJapones-1));
                                    miArrayListMenuRemoveJapones.remove(platilloJapones-1);
                                    break;
                                }
                                break;  
                            case 2:
                                System.out.println("\n\n¿De qué especialidad deseas eliminar?\n"); 
                                System.out.println("\n\t°Especialidad Mexicana (1)\n\t°Especialidad Italiana (2)\n\t°Especialidad Japonesa (3)\n"); 

                                Scanner eliminarEspecialidad = new Scanner(System.in);
                                int eliminarPlatillo;
                                eliminarPlatillo = eliminarEspecialidad.nextInt();
                                switch (eliminarPlatillo){
                                    case 1:
                                        Scanner eliminarMexicano = new Scanner(System.in);
                                        int precioMexicano;
                                        System.out.println("¿Qué platillo ya no se encuentra disponible?: ");
                                        precioMexicano = eliminarMexicano.nextInt();
                                        miArrayListMenuMexicano.remove(precioMexicano-1);
                                        miArrayListMenuRemoveMexicano.add(vistaMenuMexicano[precioMexicano-1]);
                                        break;

                                    case 2:
                                        Scanner eliminarItaliano = new Scanner(System.in);
                                        int precioItaliano;
                                        System.out.println("¿Qué platillo ya no se encuentra disponible?: ");
                                        precioItaliano = eliminarItaliano.nextInt();
                                        miArrayListMenuItaliano.remove(precioItaliano-1);
                                        miArrayListMenuRemoveItaliano.add(vistaMenuMexicano[precioItaliano-1]);
                                        break;

                                    case 3:
                                        Scanner eliminarJapones = new Scanner(System.in);
                                        int precioJapones;
                                        System.out.println("¿Qué platillo ya no se encuentra disponible?: ");
                                        precioJapones= eliminarJapones.nextInt();
                                        miArrayListMenuJapones.remove(precioJapones-1);
                                        miArrayListMenuRemoveJapones.add(vistaMenuJapones[precioJapones-1]);
                                        break;
                                }
                                break;
                        }     
                break;
                case 3: 
                    System.out.println("Saliendo del Menú...");
                    salidaMenu=1;
                    break;                
            }
        }while (salidaMenu==0);
        salidaMenu=0;       
    }
    
}

