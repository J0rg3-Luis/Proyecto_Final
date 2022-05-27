/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase creada para la generacion de n platillos aleatorios, basado en el menu, que estarán disponibles para aquellos clientes que realicen un pedido. Aunado a esto, imprime a consola los platillos generados. 
 * @author Equipo F
 */
public class ModuloGeneradorPlatillos {

    public  ModuloGeneradorPlatillos() {
    }
    /**
     * Método que genera un numero 'ra' de platillos aleatorios y los guarda en la lista de platillos que recibe como parametro, guardandolos de manera paralela en un archivo de texto. Aquí es utilizada la clase platillos para crear objetos de este tipo y tener asignados en los atributos su nombre y precio correspondiente, por cada platillo creado aleatoriamente.
     * @param lista La lista de los platillos generados en un ArrayList
     */
    public void generandoPlatillos(ArrayList<Platillos> lista) {
        String [] matriz = {"Tacos", "Quesadillas","Sopes","Pozole","Tortas","Tlacoyos","Tostadas",
        "Tamales","Mole","Flautas","Pizza","Lasaña","Antipasti","Espagueti","Ravioles","Risotto","Ensalda Capresse",
        "Ossobuco","Tiramisu","Gelato","Sushi","Onigiri","Sashimi","Sopa miso","Udon","Ramen","Mochi","Takoyaky","Dango","Gohan"};
        int [] precio = {25,20,18,30,26,16,17,14,25,35,150,120,70,50,80,90,80,60,100,85,90,80,50,75,100,120,85,85,95,110};
        
        try{
            
            
            FileWriter fw=new FileWriter("BaseDatosplatillos.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida2 =new PrintWriter(bw);
            
            Random ramdon=new Random();
            int ra=ramdon.nextInt(200-150)+150;
            
            
            for (int i = 0; i < ra; i++) {

                int numero = (int) (Math.random()*30);
                Platillos platillos = new Platillos();
                int b = precio[numero];
                String a = matriz[numero];
                platillos.setNombre(a); 
                platillos.setPrecio(b);
                lista.add(platillos);
              
                salida2.println(platillos);
                
            }
        salida2.close();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ModuloGeneradorPlatillos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Método que leé e imprime por renglon el contenido del archivo BaseDatosplatillos, donde se encuentra el listado completo de la cantidad de platillos disponibles
     */
    public void mostrarPlatillos() {
        
        try {
           FileReader fr1 = new FileReader("BaseDatosplatillos.txt");
            BufferedReader br1= new BufferedReader(fr1);
            String linea = br1.readLine();
            int cont=0;
            int i=1;
            String  auxiliar;
            while (linea!= null){
                
                StringTokenizer tokenizador1= new StringTokenizer(linea,",");
                Platillos platillo1 = new Platillos();
                while(tokenizador1.hasMoreElements()){
                    //System.out.println(tokenizador1.nextElement());
                    auxiliar=tokenizador1.nextToken();
                    //System.out.println(auxiliar);
                    if(cont==0)
                        platillo1.setNombre(auxiliar);
                    else if(cont==1)
                        
                        platillo1.setPrecio(Float.parseFloat(auxiliar));

                    cont++;
                }
                System.out.println(i+") "+platillo1.mostrarPlatillo());
                linea= br1.readLine();
                i++;
                cont=0;
            }
            br1.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloGeneradorPlatillos.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ModuloGeneradorPlatillos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }    
}
    

