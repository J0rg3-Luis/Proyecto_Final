/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Platillos;
import vista.VistaMenu;

/**
 * Clase elaborada para hacer un pedido de manera manual, permitiendo al trabajador del restaurante atender tambien de manera idividual
 * @author Equipo_F
 */

public class PedidosCliente {
    ArrayList<Platillos> lista;
    private String pedidoAcum="";
    private String pedidoAcumVenta="";
    private float monto;
    private String envoltura="";
    private String cubierto="";
            
    
    public PedidosCliente() {
        
    }
    /**
     * Método que busca la disponibilidad del platillo solicitado por el cliente dentro de la lista (el parametri recibido) que almacena el inventario de platillos, una vez negada o aceptada la peticion, brinda la posibilidad de solicitar un nuevo platillo. Al final de la orden, el metodo pregunta el tipo de envoltura y cubiertos que prefiere el cliente. 
     * @param lista La lista de los platillos generados en un ArrayList
     */
     public void buscarPedidos(ArrayList<Platillos>lista){
        int choise=0, c1=0, e1=0;
        String [] matriz = {"Tacos", "Quesadillas","Sopes","Pozole","Tortas","Tlacoyos","Tostadas",
        "Tamales","Mole","Flautas","Pizza","Lasaña","Antipasti","Espagueti","Ravioles","Risotto","Ensalda Capresse",
        "Ossobuco","Tiramisu","Gelato","Sushi","Onigiri","Sashimi","Sopa miso","Udon","Ramen","Mochi","Takoyaky","Dango","Gohan"};
        int [] precio = {25,20,18,30,26,16,17,14,25,35,150,120,70,50,80,90,80,60,100,85,90,80,50,75,100,120,85,85,95,110};
        String [] envoltorio={"Plastico", "Carton"};
        String [] cubiertos={"Con cubiertos", "Sin cubiertos"};
        VistaMenu vistaMenu = new VistaMenu();
        vistaMenu.ControladorMenu2();
         while (choise!=2) {/////////////////////////////////////////////////
             System.out.println("Elija platillo");
             Scanner orden = new Scanner (System.in);
        int p1;  
        p1 = orden.nextInt();
        String nomPlatillo;
        nomPlatillo=matriz[p1-1];
        
        System.out.println("El platillo que eligio es: "+nomPlatillo);
        int pos=-1;
         for (int i = 0; i <lista.size(); i++) {
             if(lista.get(i).getNombre().equals(nomPlatillo)){
                 pos=i;
             }
         }
         if(pos!=-1){
             //System.out.println("Se encontro el  "+(pos+1));
             System.out.println("Se encontro el platillo solicitado....");
             monto+=precio[p1-1];
             pedidoAcum+=""+matriz[p1-1]+"...... "+precio[p1-1]+"$\n";
             pedidoAcumVenta+=matriz[p1-1]+"/ ";
             
            lista.remove(pos);
            System.out.println("Elija su envoltura: 1)Carton o 2)Plastico");
            Scanner opcion2 = new Scanner (System.in);
            c1=opcion2.nextInt();
            envoltura+=envoltorio[c1-1];
            System.out.println("1)Con cubiertos o 2)Sin cubiertos");
            Scanner opcion3 = new Scanner (System.in);
            e1=opcion3.nextInt();
            cubierto+=cubiertos[e1-1];
             
         }else
             System.out.println("¡El platillo no esta disponible por el momento, los sentimos!");
         
         System.out.println("##################################################");
             System.out.println("¿Desea buscar otro platillo u ordenar algo más?");
             System.out.println("Si=1\nNo=2");
             Scanner opcion = new Scanner (System.in);
             choise=opcion.nextInt();
         }

  }

    
     
     /**
      * Método que genera el ticket de la venta realizada, asi como el monto total y la envoltura. De manera paralela, agrega la venta a las ventas totales del dia, así como agregarlo al archivo VentasDelDia.
      * @param numCliente El número del cliente que realiza una compra
      * @param listaDePedido2 El contador que asigna la impresión del cliente, platillo, total, tipo de envoltura y cubiertos
      * @param ventasDelDia La lista de la venta de platillos realizados en un ArrayList
      */
    public void generarTicket(int numCliente, int listaDePedido2, ArrayList<String> ventasDelDia) {
        String linea= "Cliente "+numCliente+"\n"+pedidoAcum+"\nTOTAL............."+monto+"$\n"+envoltura+", "+cubierto;
        String venta= numCliente+","+pedidoAcumVenta+","+monto+","+envoltura+","+cubierto;
        
        
        
        try{
 
        ventasDelDia.add(venta);
        
        FileWriter fw1=new FileWriter("VentasDelDia.csv");
        BufferedWriter bw1= new BufferedWriter(fw1);
        PrintWriter salida1 =new PrintWriter(bw1);
        if (listaDePedido2==0){
            salida1.println("\nCliente,Platillo,Total,Tipo de envoltura,Cubiertos");
        }
        for (String ventas : ventasDelDia) {
            salida1.println(ventas);
        }

        salida1.close();

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        FileWriter fw =new FileWriter("cliente"+numCliente+".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);
        
        //elementos para el tokenizer
        float  temp=0;
        String textoTemporal;
        StringTokenizer tokenizador = new StringTokenizer (linea, "\n");
        
         while (tokenizador.hasMoreTokens()){
            textoTemporal=tokenizador.nextToken();
           salida.println(textoTemporal);
            temp++;
            
        }
         salida.close();
        
        
        }catch(IOException ex) {
            Logger.getLogger(PedidosCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(linea);
    }

    public String getEnvoltura() {
        return envoltura;
    }

    public String getCubierto() {
        return cubierto;
    }    
}



