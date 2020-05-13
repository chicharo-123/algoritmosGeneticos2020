/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.Random;

/**
 *
 * @author cesar
 */
public class Seleccion {
      public static Individuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.getIndivduos().size());
        Individuo mejor = new Individuo(pob.getIndivduos()
                   .get(pos).getGenotipo());
        return mejor;
    }
}
