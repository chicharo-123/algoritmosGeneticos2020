/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGeneticos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Haide
 */
public class cruza{

public static int[] hijo1 = new int[13];

public static AIndividuo cruzaXMascara(int mascara[], AIndividuo madre, AIndividuo padre){
         int genotipo1 [] = new int[mascara.length];
        int genotipo2 [] = new int[mascara.length];


       AIndividuo hijo2 = new AIndividuo(new int[13]);
         ///////cambiar pos en el Primer 1////////////////////
       Random r = new Random();
       int pos = r.nextInt(hijo2.getGenotipo().length);
       hijo2.getGenotipo()[pos]=1;

        
         ///////cambiar pos en el segundo 1////////////////////
         Random s = new Random();
       int pos2 = s.nextInt(hijo2.getGenotipo().length);
       hijo2.getGenotipo()[pos2]=1;
        
        for(int j=0;j<hijo1.length;j++){
    System.out.print(hijo2.getGenotipo()[j]);
        }
        
       return hijo2;
      
    }




    public static int[] cruzaPorMascara(int mascara[], AIndividuo madre, AIndividuo padre){
         int genotipo1 [] = new int[mascara.length];
        int genotipo2 [] = new int[mascara.length];


       int[] hijo1 = new int[13];
         ///////cambiar pos en el Primer 1////////////////////
         Random r = new Random();
         int pos = r.nextInt(hijo1.length);
        hijo1[pos]=1;

        
         ///////cambiar pos en el segundo 1////////////////////
         Random s = new Random();
         int pos2 = s.nextInt(hijo1.length);         
        hijo1[pos2]=1;
        
//        for(int j=0;j<hijo1.length;j++){
//System.out.print(hijo1[j]);
//        }
        
       return hijo1;
      
    }
    
//    public static void main(String[] args){
//        int mascara [] = new int[]{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0};
//    
//        AIndividuo madre = new AIndividuo(new int[16]);
//        AIndividuo padre = new AIndividuo(new int[16]);
//        
//        int genotipo1 [] = new int[mascara.length];
//        int genotipo2 [] = new int[mascara.length];
////        int mascara [] = new int[]{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0};
////        cruza.cruzaPorMascara(mascara, jr, jr);
////        for(int i=0;i<16;i++){
////           System.out.println(""+cruza.cruzaPorMascara(mascara, jr, jr));
////        }
////    }
//
// AIndividuo hijo1 = new AIndividuo(genotipo1);
//        AIndividuo hijo2 = new AIndividuo(genotipo2);
//         ///////cambiar pos en el Primer 1////////////////////
//         Random r = new Random();
//         int pos = r.nextInt(hijo1.getGenotipo().length);
//        hijo1.getGenotipo()[pos]=1;
//
//        
//         ///////cambiar pos en el segundo 1////////////////////
//         Random s = new Random();
//         int pos2 = s.nextInt(hijo1.getGenotipo().length);         
//        hijo1.getGenotipo()[pos2]=1;
//        
//        for(int i=0;i<16;i++){
//              System.out.println(""+hijo1.getGenotipo()[i]);
//        }
//}

    public int[] getHijo1() {
        return hijo1;
    }
}