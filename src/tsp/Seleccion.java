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
public class seleccion {
     public static tsp.Individuo seleccionAleatoria(tsp.Poblacion pob){
        Random ran = new Random();
       int pos = ran.nextInt(pob.getPoblacion().size());

       return new tsp.Individuo(pob.getPoblacion().get(pos).getGenotipo()); 
    }
}
