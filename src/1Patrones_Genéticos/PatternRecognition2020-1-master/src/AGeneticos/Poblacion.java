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

import java.util.LinkedList;
import java.util.Random;

public class Poblacion{

    private LinkedList<AIndividuo> poblacion;
    private int i;

    public Poblacion(int i){
        this.i = i;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    public Poblacion(LinkedList<AIndividuo> muestra, int i){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new AIndividuo(muestra.get(x).getGenotipo()));
        }
    }


      public Poblacion(){
        this.poblacion = new LinkedList<>();
        
    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        for(AIndividuo aux: n.getPoblacion()){
            this.poblacion.add(new AIndividuo(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(){

       for(int x=0; x< this.i; x++){
            this.poblacion.add(new AIndividuo(14));

       }

    }
    public LinkedList<AIndividuo> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<AIndividuo> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public LinkedList<AIndividuo> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<AIndividuo> muestra = new LinkedList<>();
        // ordenar los elementos
     return muestra;
    }
   
   public LinkedList<AIndividuo> getPoblacion(){

    return poblacion;
   }
}
