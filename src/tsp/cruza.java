/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Don Gary
 */
public class cruza {
  
//   public static  Individuo Asexual( Individuo madre, Individuo padre){
//      
//         
//        int genotipo1 [] = new int[madre.getGenotipo().length-1];
//        int genotipo2 [] = new int[padre.getGenotipo().length-1];
//       
//            
//        // recorremos la mascara de cruza 
//        for (int b=0; b < genotipo1.length; b++){
//  
//                genotipo1[b]=madre.getGenotipo()[b];
//                genotipo2[b] =padre.getGenotipo()[b];
//            }
//       
//        /////////////Encontramos hijo1
//        Individuo hijo1 = new Individuo(genotipo1);
//
//        
//         ///////cambiar pos en el hijo////////////////////
//         Random r = new Random();
//         Random s = new Random();
//
//         int pos = r.nextInt(hijo1.getGenotipo().length-1)+1;
//         int pos2 = s.nextInt(hijo1.getGenotipo().length-1)+1;
//      
//        Individuo r1 = new Individuo(5,70);
//        r1.getGenotipo()[1]=hijo1.getGenotipo()[pos];
//        r1.getGenotipo()[2]=hijo1.getGenotipo()[pos2];
//        
//        
//        
//        //cambio de pos en el HIJO1 //////////////////////////
//        hijo1.getGenotipo()[pos]= r1.getGenotipo()[2];
//        hijo1.getGenotipo()[pos2] = r1.getGenotipo()[1]; 
//        
//     
//        
//     
///////////////////////AHORA PARA EL HIJO 2 /////////////////////////////////////////////
//////////Encontramos al hijo 2////////////////////
//        Individuo hijo2 = new Individuo(genotipo2);
//       
//         ///////cambiar pos en el hijo////////////////////
//         Random i = new Random();
//         Random j = new Random();
//         //int po3 = i.nextInt(20) + 1;
//         //int po4 = j.nextInt(20) + 1;
//         
//         int pos3 = i.nextInt(hijo2.getGenotipo().length -1)+1;
//         int pos4 = j.nextInt(hijo2.getGenotipo().length-1)+1;
//         ////////////////////////Si es la posicion 0/////////////////////////////
//        
//            
//        Individuo r2 = new Individuo(5,70);
//        r2.getGenotipo()[1]=hijo1.getGenotipo()[pos3];
//        r2.getGenotipo()[2]=hijo1.getGenotipo()[pos4];
//        
//        
//        //cambio de pos en el HIJO2 //////////////////////////
//        hijo2.getGenotipo()[pos3]= r2.getGenotipo()[2];
//        hijo2.getGenotipo()[pos4] = r2.getGenotipo()[1]; 
//        
//        
//       
//       
//       
//       hijo1.calcularFitness();
//       hijo2.calcularFitness();
//       //////////////////////////////COMPARACIÓN//////////////////////////////////////////////////////////
//        if (hijo1.getFitness()<hijo2.getFitness()){
//            //System.out.println("El mejor es: "+hijo1.getFitness());
//            return hijo1;
//        } else {
//            //System.out.println("El mejor es: "+hijo2.getFitness());
//            return hijo2;
//        }
//          }
   

    public static Individuo Asexual(Individuo padre,Individuo madre){
        int genotipo1[] = new int[padre.getGenotipo().length-1];
        // creo la mascara de índices 
        for(int i=0;i<genotipo1.length;i++){
            genotipo1[i] = -1;
        }
        for (int j=1; j<= genotipo1.length;j++){
            int ind = generarIndiceValido(genotipo1);
            genotipo1[ind]=j;
        }
        
        
        
        int geno1[] = new int[padre.getGenotipo().length];
        int geno2[] = new int[madre.getGenotipo().length];
        geno1[0] = padre.getGenotipo()[0];
        geno2[0] = madre.getGenotipo()[0];
        // construimos los nuevos genotipos
        for (int x=1;x<geno1.length;x++){
           geno1[genotipo1[x-1]]=padre.getGenotipo()[x];
           geno2[genotipo1[x-1]]=madre.getGenotipo()[x];
        }
       Individuo hijo1 =  new Individuo(geno1);
       Individuo hijo2 =  new Individuo(geno2);
         
       ArrayList<Individuo> lista = new ArrayList<>();
       lista.add(madre);
       lista.add(padre);
       lista.add(hijo1);
       lista.add(hijo2);
       return retornaMejor(lista);
    }

    private static Individuo retornaMejor(ArrayList<Individuo> lista) {
        Individuo mejor = lista.get(0);
        
        for (int x=1; x<lista.size();x++){
           if(lista.get(x).getFitness()<mejor.getFitness()){
            mejor =lista.get(x);
           }
        }
        return mejor;
    }
    
    public static int generarIndiceValido(int[] ruta) {
        Random r = new Random();
        int indice = r.nextInt(ruta.length);
        while(ruta[indice] != -1){
            indice = r.nextInt(ruta.length);
        }
        
        return indice;
    }
    
   
   
}
//    
//   public static  Individuo Asexual(int mascara[], Individuo madre, Individuo padre){
//      
//       /*Individuo madre = new Individuo(ci,n);
//           madre.inicializarAleatoriamente();
//        Individuo padre = new Individuo(ci,n);
//            padre.inicializarAleatoriamente();
//        
//            int mascara [] = new int[]{0,0,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,1,1};
//            */
//            
//            
//        int genotipo1 [] = new int[mascara.length];
//        int genotipo2 [] = new int[mascara.length];
//       
//            
//        // recorremos la mascara de cruza 
//        for (int b=0; b < mascara.length; b++){
//            if(mascara[b]==1){
//                genotipo1[b]=madre.getGenotipo()[b];
//                genotipo2[b] =padre.getGenotipo()[b];
//            }
//       else{
//                genotipo1[b]=padre.getGenotipo()[b];
//                genotipo2[b] = madre.getGenotipo()[b];
//
//            }
//        }
//        /////////////Encontramos hijo1
//        Individuo hijo1 = new Individuo(genotipo1);
//        //System.out.println("Genotipo Hijo 1 antes: "+genotipo1[0]+","+genotipo1[1]+","+genotipo1[2]+","+genotipo1[3]+","+genotipo1[4]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);
//       // System.out.println("Fitnes Hijo1  antes: "+hijo1.getFitness());
//       // System.out.print("soy el hijo1 antes:"+hijo1.getGenotipo()[0]);
//       // for(int o =1; o<20;o++)
//         //  System.out.print(", "+hijo1.getGenotipo()[o]);
//        
//         ///////cambiar pos en el hijo////////////////////
//         Random r = new Random();
//         Random s = new Random();
//         int pos = r.nextInt(hijo1.getGenotipo().length);
//         int pos2 = r.nextInt(hijo1.getGenotipo().length);
//        
//        Individuo r1 = new Individuo(4,20);
//        r1.getGenotipo()[1]=hijo1.getGenotipo()[pos];
//        r1.getGenotipo()[2]=hijo1.getGenotipo()[pos2];
//        
//        /*
//        System.out.println("Posr Hijo 1 : "+hijo1.getGenotipo()[pos]);
//        System.out.println("PosS Hijo 1 : "+hijo1.getGenotipo()[pos2]);
//        System.out.println("R1_1 Hijo 1 : "+r1.getGenotipo()[1]);
//        System.out.println("R2_2 Hijo 1 : "+r1.getGenotipo()[2]);
//        */
//        
//        //cambio de pos en el HIJO1 //////////////////////////
//        hijo1.getGenotipo()[pos]= r1.getGenotipo()[2];
//        hijo1.getGenotipo()[pos2] = r1.getGenotipo()[1]; 
//
//        
//      //  System.out.println("Posr Hijo 1 ahora: "+hijo1.getGenotipo()[pos]);
//       // System.out.println("PosS Hijo 1 ahora: "+hijo1.getGenotipo()[pos2]);
//        
//        
//       // System.out.println("Fitness Hijo 1: "+hijo1.getFitness());
//        
//        
//        //System.out.print("soy el hijo1:"+hijo1.getGenotipo()[0]);
//        //for(int i =1; i<20;i++)
//          // System.out.print(", "+hijo1.getGenotipo()[i]);
//        
//        
//        
////System.out.println("Genotipo Hijo 1 ahora: "+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);
//        
///////////////////////AHORA PARA EL HIJO 2 /////////////////////////////////////////////
//////////Encontramos al hijo 2////////////////////
//        Individuo hijo2 = new Individuo(genotipo2);
//        //System.out.println("Genotipo Hijo 2 antes: "+genotipo1[0]+","+genotipo1[1]+","+genotipo1[2]+","+genotipo1[3]+","+genotipo1[4]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);
//       // System.out.println("Fitnes Hijo1  antes: "+hijo1.getFitness());
//       // System.out.print("soy el hijo2 antes:"+hijo2.getGenotipo()[0]);
//       // for(int l =1; l<20;l++)
//         //  System.out.print(", "+hijo2.getGenotipo()[l]);
//        
//         ///////cambiar pos en el hijo////////////////////
//         Random i = new Random();
//         Random j = new Random();
//         int pos3 = i.nextInt(hijo2.getGenotipo().length);
//         int pos4 = j.nextInt(hijo2.getGenotipo().length);
//        
//        Individuo r2 = new Individuo(4,20);
//        r2.getGenotipo()[1]=hijo1.getGenotipo()[pos3];
//        r2.getGenotipo()[2]=hijo1.getGenotipo()[pos4];
//        
//        
//        //cambio de pos en el HIJO2 //////////////////////////
//        hijo2.getGenotipo()[pos3]= r2.getGenotipo()[2];
//        hijo2.getGenotipo()[pos4] = r2.getGenotipo()[1]; 
//
//        
//        //System.out.println("Posr Hijo 2 ahora: "+hijo2.getGenotipo()[pos3]);
//        //System.out.println("PosS Hijo 2 ahora: "+hijo2.getGenotipo()[pos4]);
//        
//        
//        //System.out.println("Fitness Hijo 2: "+hijo2.getFitness());
//        
//        
//        //System.out.print("soy el hijo 2:"+hijo2.getGenotipo()[0]);
//        //for(int k=1; k<20;k++)
//         //  System.out.print(", "+hijo2.getGenotipo()[k]);
//        
// 
//        
////System.out.println("\n Fitness Hijo2: "+hijo2.getFitness());
//       // System.out.println("Genotipo Hijo 2: "+genotipo2[0]+","+genotipo2[1]+","+genotipo2[2]+","+genotipo2[3]);
//        
//       
//       
//       
//       hijo1.calcularFitness();
//       hijo2.calcularFitness();
//       //////////////////////////////COMPARACIÓN//////////////////////////////////////////////////////////
//        if (hijo1.getFitness()<hijo2.getFitness()){
//            //System.out.println("El mejor es: "+hijo1.getFitness());
//            return hijo1;
//        } else {
//            //System.out.println("El mejor es: "+hijo2.getFitness());
//            return hijo2;
//        }
//          }
    
    
