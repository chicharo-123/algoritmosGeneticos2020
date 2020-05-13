/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Don Gary
 */
public class Poblacion {

    private LinkedList<Individuo> poblacion;
    private int i;

    // creacion aleatoria de la poblaciÃ³n
    public Poblacion(int i, int ci, int n){
        this.i = i;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente(ci,n);
    }

    // creacion  poblaciÃ³n con muestreo
    public Poblacion(LinkedList<Individuo> muestra, int i){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo()));
        }
        // ver como se resolverÃ¡ el
    }

      // creacion  poblaciÃ³n con muestreo
      public Poblacion(){
        this.poblacion = new LinkedList<>();
        
    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        // crear un nueva poblaciÃ³n en base a otra 
        for(Individuo aux: n.getPoblacion()){
            this.poblacion.add(new Individuo(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(int ci, int n){

       // un proceso iterativo con respecto a i
       for(int x=0; x< this.i; x++){
            this.poblacion.add(new Individuo(ci,n));

       }

    }
    

    
   
   public LinkedList<Individuo> getPoblacion(){

    return poblacion;
   }
}    

