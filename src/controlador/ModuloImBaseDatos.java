/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pedidos;
import modelo.Platillos;

/**
 *Clase que genera los archivos csv de las ventas y platillos listos, almacenados anteriormente en un archivo txt
 * @author Equipo_F
 */
public class ModuloImBaseDatos {
    /**
     * Método que genera la escritura en un archivo csv tomando en cuenta la base de datos de ventas; en este archivo son almacenados todos los detalles de las ventas.
     */
    public void archivoVentas() {
        
        try {
            FileReader fr1 = new FileReader("BaseDatosVentas.txt");
            BufferedReader br1= new BufferedReader(fr1);
            String linea1 = br1.readLine();
            
            FileWriter fw1=new FileWriter("VentasRealizadas.csv");
            
            BufferedWriter bw= new BufferedWriter(fw1);
            PrintWriter salida =new PrintWriter(bw);
            salida.println("Platillo,Precio,Tipo de envoltura,Cubiertos");
            
            while (linea1 != null) {
                salida.println(linea1);
                linea1=br1.readLine();
                
            }
            br1.close();
            salida.close();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
    }
    /**
     * Método que genera el archivo csv correspondiente a la base de pedidos listos, esta tambien es almacenada con todos los detlles del pedido (envoltura y cubiertos)
     */
    public void archivoPedidosListos(){
            try {
            FileReader fr1 = new FileReader("BasePedidosListos.txt");
            BufferedReader br1= new BufferedReader(fr1);
            String linea1 = br1.readLine();
            
            FileWriter fw1=new FileWriter("PedidosListos.csv");
            BufferedWriter bw= new BufferedWriter(fw1);
            PrintWriter salida =new PrintWriter(bw);
            
            salida.println("Pedidos,listos,para,ser,empacados");
            salida.println("Platillo,Precio,Tipo de envoltura,Cubiertos");
            while (linea1 != null) {
                salida.println(linea1);
                linea1=br1.readLine();
                
            }
            br1.close();
            salida.close();
          
  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    /**
     * Método que imprime las ventas realizadas en el dia, almacenadas anteriomente en el archivo BaseDatosVentas
     */
    public void mostrarVentas(){
         
        try {
            FileReader fr = new FileReader("BaseDatosVentas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            int cont=0;
            int i=1;
            String  auxiliar;
            System.out.println("#################################################");
            System.out.println("*******Ventas realizadas*********");
            System.out.println("\n");
            while (linea!= null){
                
                StringTokenizer tokenizador1= new StringTokenizer(linea,",");
                Pedidos p1 = new Pedidos();
                while(tokenizador1.hasMoreElements()){
                    //System.out.println(tokenizador1.nextElement());
                    auxiliar=tokenizador1.nextToken();
                    //System.out.println(auxiliar);
                    if(cont==0)
                        p1.setNomPlatillo(auxiliar);
                    else if(cont==1)
                        //pedido1.setPrecio(Float.parseFloat(auxiliar));
                        p1.setPrecio(Float.parseFloat(auxiliar));
                    else if(cont==2)
                        p1.setTipoEnvoltura(auxiliar);
                    else if(cont==3)
                        p1.setCubiertos(auxiliar);

                    cont++;
                }
                System.out.println(i+") "+p1.pedidoVendido());
                linea= br.readLine();
                i++;
                cont=0;
            }
   
            br.close();   
        System.out.println("\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    /**
     * Método que imprime a pantalla los pedidos que están listos para ser entregados
     */
    public void mostrarPedidosListos(){
                   
        try {
            FileReader fr = new FileReader("BasePedidosListos.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("#############################################");
            System.out.println("*******Pedidos listos para ser empacados*********");
            System.out.println("\n");
            String linea = br.readLine();
            int cont=0;
            int i=1;
            String  auxiliar;
            while (linea!= null){
                
                StringTokenizer tokenizador1= new StringTokenizer(linea,",");
                Pedidos p1 = new Pedidos();
                while(tokenizador1.hasMoreElements()){
                    //System.out.println(tokenizador1.nextElement());
                    auxiliar=tokenizador1.nextToken();
                    //System.out.println(auxiliar);
                    if(cont==0)
                        p1.setNomPlatillo(auxiliar);
                    else if(cont==1)
                        //pedido1.setPrecio(Float.parseFloat(auxiliar));
                        p1.setPrecio(Float.parseFloat(auxiliar));
                    else if(cont==2)
                        p1.setTipoEnvoltura(auxiliar);
                    else if(cont==3)
                        p1.setCubiertos(auxiliar);

                    cont++;
                }
                System.out.println(i+") "+p1.mostrarPedido());
                linea= br.readLine();
                i++;
                cont=0;
            }
            br.close(); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModuloImBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
