/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.Random;

/**
 *
 * @author Don Gary
 */
public class muta {
//     public static void aplicarMutaAleatoria(Individuo p){
//        Random r = new Random();
//         Random s = new Random();
//         int pos = r.nextInt(p.getGenotipo().length);
//         int pos2 = s.nextInt(p.getGenotipo().length);
//        
//        Individuo r1 = new Individuo(4,20);
//        r1.getGenotipo()[1]=p.getGenotipo()[pos];
//        r1.getGenotipo()[2]=p.getGenotipo()[pos2];
//        
//        if(p.getGenotipo()[pos]==r1.getGenotipo()[1] ){
//            p.getGenotipo()[pos]=r1.getGenotipo()[2];
//
//        }else {
//             p.getGenotipo()[pos2]=r1.getGenotipo()[1];
//        }
//        // actualizar el genotipo, fenotipo y fitness
//        p.calcularFitness();
//
//    }
     public static void mutaGen(double prob,Individuo ind){
       double aux = Math.random();
    if(aux<=prob){
        // modificar un bit del genotipo
        Random ran = new Random();
        int posGen = ran.nextInt(ind.getGenotipo().length-1)+1;
        int valor =ind.getGenotipo()[posGen]; 
        int posGen2= ran.nextInt(ind.getGenotipo().length-1)+1;
        ind.getGenotipo()[posGen] = ind.getGenotipo()[posGen2]; 
        ind.getGenotipo()[posGen2] = valor; 
        
        // actualizamos el fenotipo y el fitness
//        ind.actualizarIndividuo();
ind.calcularFitness();
        
    }
     }
}
