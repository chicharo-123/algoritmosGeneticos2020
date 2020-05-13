/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author cesar
 */
public class GeneticoReinas {
      // parametros
    private Poblacion poblacionActual;
//    private Configuracion manager;

 private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public GeneticoReinas(int num_G,double pMuta,int tamPob, int n){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la poblaciÃ³n inicial como aleatoria
        this.pobActual = new Poblacion(tamPob,n);

        for(int i=0 ;i<num_G;i++){
            //System.out.print(i+":");
                 //     Individuo h = new Individuo(20);
          Individuo h = new Individuo(10);
            if (h.getFitness()==0){
              System.out.println("g: "+i+" "+Arrays.toString(h.getGenotipo()));
              break;
            }
        }
        
    }
    
    public void evolucionar(){
   
    // generar las itereaciones para las generaciones
    for(int g=1;g<num_G;g++){
        // garantizar construir una nueva población
        ArrayList<Individuo> ind;
        // calcular un N
        int n = (int)(this.tamPob*this.tamPob);
        if (n>0){
        ind = new ArrayList<>();
        ind.add(this.pobActual.getMejor());
        
        }else {
        ind = new ArrayList<>();
        }
        for(int i=n; i<this.tamPob;i++){
            // seleccionamos
            Individuo madre = Seleccion.seleccionAleatoria(pobActual);
            Individuo padre = Seleccion.seleccionAleatoria(pobActual);
            // reproducimos
            int a[]={1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1};
            Individuo hijo = Cruza.cruzaXMascara( a, madre, padre);
            // mutamos 
            // evaluar la probabilidad
            Muta.mutaGen(this.pMuta, hijo);
            // agregamos
            ind.add(hijo);

        }
        // actualizamos la nueva población
        this.pobActual = new Poblacion(ind);
      //System.out.println(g);
      // pedimos el mejor a la poblacion 
    Individuo mejor  = this.pobActual.getMejor();
    int f = mejor.getFitness();
    System.out.println("g: "+g+" f:"+f);
    if(f==0){
        
        System.out.println("g: "+g+" "+Arrays.toString(mejor.getGenotipo()));
    
        break;
    }
    }
    // pedimos el mejor a la poblacion 
//    Individuo mejor  = this.poblacionActual.getMejor();
//    System.out.println(mejor.getFitness());
    //System.out.println(Arrays.toString(mejor.getGenotipo()));
    }


   
  

  
    
}
