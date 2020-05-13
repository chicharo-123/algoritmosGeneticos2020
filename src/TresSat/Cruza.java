/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresSat;

import java.util.Random;

/**
 *
 * @author chicharo
 */
public class Cruza {
    
      public static int[] generarMascaraAleatoria(int dim){
    int mask[]= new int[dim];
    Random ran = new Random();
    
    for(int x=0; x<dim;x++){
    mask[x]=ran.nextInt(2);
    }
    return mask;
    }
    public static Individu cruzaPorMascara(int mask[], Individu madre, Individu padre){
        Individu hijo1,hijo2;
        int geno1[] = new int[100];
        int geno2[] = new int[100];
    // recorrer la maskara de cruza
    for (int x=0; x<mask.length;x++){
        // 1 madre y 0 padre
        if(mask[x]==1){
            geno1[x]=madre.getGenotipo()[x];
            geno2[x]=padre.getGenotipo()[x];
        
        }else{
            geno1[x]=padre.getGenotipo()[x];
            geno2[x]=madre.getGenotipo()[x];
        }
    }
    hijo1 = new Individu(geno1);
    hijo2 = new Individu(geno2);
    
    if (hijo1.getFitness()>hijo2.getFitness()){
        return hijo1;}
    else{return hijo2;}
    
    }

   
}