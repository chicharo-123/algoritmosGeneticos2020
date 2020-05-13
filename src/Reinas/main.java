/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

/**
 *
 * @author cesar
 */
public class main {
     public static void main(String[] args) {
        
           try {
           System.out.println();
//      //Individuo i = new Individuo(3,500);
        Individuo i = new Individuo(10);
      Cruza.generarMascaraAleatoria(10);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace(); 
    }
    
    
    System.out.println("\n \n \n");
   GeneticoReinas gen = new GeneticoReinas(300000,0.45,10,10);
       //gen.evolucionar();
        //20,80,100
     }
}
