/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase responsable de la creacion de los pedidos, tomando en cuenta el menu y la disponibilidad de  los mismos. 
 * @author Equipo_F
 */
public class ModuloPedidos {

    public ModuloPedidos() {
    }
    /**
     * Método que en base a la disponibilidad de la BaseDatosplatillos, este método crea pedidos aleatorios con su envoltorio y cubiertos, mandando a crear una base de datos que generen estos mismos pedidos. 
     */
    public void pedidos(){
                
        try {
            FileReader fr1=new FileReader("BaseDatosplatillos.txt");
            BufferedReader br1= new BufferedReader(fr1);
            String linea2 = br1.readLine();
            ArrayList<Pedidos> listaPedidos = new ArrayList<Pedidos>();
            int cont=0;
            int i=0;
            int corte=1;
            String auxiliar;
           
            while (linea2!= null) {
                StringTokenizer tokenizador1= new StringTokenizer(linea2,",");
                Pedidos pedido1 = new Pedidos();
                
                while(tokenizador1.hasMoreElements()){
                    
                    auxiliar=tokenizador1.nextToken();
                    
                    if(cont==0)
                        pedido1.setNomPlatillo(auxiliar);
                    else if(cont==1)
                        pedido1.setPrecio(Float.parseFloat(auxiliar));
                    cont++;
                }
                listaPedidos.add(pedido1);
                linea2= br1.readLine();
                corte++;
                if(corte ==101)
                    break;
                cont=0;
            }
            br1.close();
            String[] vector={"Plastico","Carton","Carton","Plastico"};
            String[] vector2={"Con cubiertos","Sin cubiertos","Con cubiertos","Sin cubiertos"};
            
            
            
            for (Pedidos listaPedido : listaPedidos) {
                int numero = (int) (Math.random()*4);
                String a = vector[numero];
                String b = vector2[numero];
                listaPedido.setCubiertos(b);
                listaPedido.setTipoEnvoltura(a);
            }
            FileWriter fw =new FileWriter("BaseDatosVentas.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida =new PrintWriter(bw);
            
            for (Pedidos listaPedido : listaPedidos) {
                salida.println(listaPedido);
            }
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModuloPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Método que imprime en pantalla el numero total de pedidos creados, además imprime cada uno de ellos a pantalla tomando la información de la lectura de BaseDatosVentas.
     */
    public void mostrarpedidos(){
        try {
           FileReader fr1 = new FileReader("BaseDatosVentas.txt");
            BufferedReader br1= new BufferedReader(fr1);
            String linea = br1.readLine();
            int cont=0;
            int i=1;
            String  auxiliar;
            System.out.println("*******************ModuloGeneradorPedidos*************************");
            while (linea!= null){
                
                StringTokenizer tokenizador1= new StringTokenizer(linea,",");
                Pedidos pedido1= new Pedidos();
                while(tokenizador1.hasMoreElements()){
                    
                    auxiliar=tokenizador1.nextToken();
                    
                    if(cont==0)
                        pedido1.setNomPlatillo(auxiliar);
                    else if(cont==1)
                        pedido1.setPrecio(Float.parseFloat(auxiliar));
                    else if(cont==2)    
                        pedido1.setTipoEnvoltura(auxiliar);
                    else if(cont==3)
                        pedido1.setCubiertos(auxiliar);

                    cont++;
                }
                System.out.println(i+") "+pedido1.pedidoVendido());
                linea= br1.readLine();
                i++;
                cont=0;
            }
            br1.close();
            System.out.println("\nTotal de pedidos: "+i);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloGeneradorPlatillos.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ModuloGeneradorPlatillos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
