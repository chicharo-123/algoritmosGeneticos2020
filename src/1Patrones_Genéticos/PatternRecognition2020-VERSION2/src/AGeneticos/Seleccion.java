/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGeneticos;
/**
 *
 * @author Haide
 */

import java.util.Random;

public class Seleccion{

    public static AIndividuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
       int pos = ran.nextInt(pob.getPoblacion().size());

       return new AIndividuo(pob.getPoblacion().get(pos).getGenotipo()); 
    }

}