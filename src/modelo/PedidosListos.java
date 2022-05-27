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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase que enfocada en dar los detalles de los pedidos que fueron vendidos por parte del restaurante
 * @author Equipo_F
 */
public class PedidosListos {
    /**
     * Método que copia las ventas para posteriormente colocarls en el archivo pedidos listos y estos puedan salir a ser entregados.
     */
    public void listaPedidosListo() {
       
        try {
            FileReader fr = new FileReader("BaseDatosVentas.txt");
            BufferedReader br1= new BufferedReader(fr);
            String linea2 = br1.readLine();
            
            FileWriter fw1=new FileWriter("BasePedidosListos.txt");
            BufferedWriter bw= new BufferedWriter(fw1);
            PrintWriter salida =new PrintWriter(bw);
            
            int parar=1;
            Random ramdon=new Random();
            int ra=ramdon.nextInt(95-50)+50;
            
            while (linea2 != null) {
                salida.println(linea2);
                linea2=br1.readLine();
                parar++;
                if (parar==ra)
                    break;
            }
            br1.close();
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PedidosListos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PedidosListos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
