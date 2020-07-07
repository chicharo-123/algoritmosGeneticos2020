/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternrecognition2020.pkg1;

import AGeneticos.AIndividuo;
import AGeneticos.cruza;
import Clasificador.clasificadores.herramientasclasificadores.AnalisisResultado;
import clasificadores.Knn;
import clasificadores.MinimaDistancia;
import clasificadores.herramientasclasificadores.Herramientas;
import clasificadores.herramientasclasificadores.Patron;
import java.util.ArrayList;

/**
 *
 * @author César Y haide :c
 */
public class PatternRecognition20201 {

    /**
     * @param args the command line arguments
     */
    public void Genetico(int gen,int p_Muta,int pob){
        int[] b =new int[13];
        AIndividuo Mejor =new AIndividuo(new int[13]);
        AIndividuo madre = new AIndividuo(new int[13]);
        AIndividuo padre = new AIndividuo(new int[13]);
        int mascara [] = new int[]{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0};
        
         for(int i=0; i<gen;i++){
           
            cruza.cruzaXMascara(mascara, madre, padre);
            System.out.println("\n");
           
//        Herramientas.leerDatos(new int[]{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0});

          Herramientas.leerDatos(cruza.cruzaPorMascara(mascara, madre, padre));
        
        MinimaDistancia md = new MinimaDistancia(Herramientas.instancias.size());
        md.entrenar(Herramientas.instancias);
        md.clasificar(Herramientas.instancias);
        System.out.println(md.getMc().toString());
        AnalisisResultado ar = new AnalisisResultado(Herramientas.instancias);
     
        System.out.println((ar.getGood()*100)/178+"%");
         b[i]=((ar.getGood()*100)/178);
       }
         
         
    }
    public static void main(String[] args) {

       for(int generaciones=0; generaciones<6;generaciones++){
            AIndividuo madre = new AIndividuo(new int[13]);
           AIndividuo padre = new AIndividuo(new int[13]);
           int mascara [] = new int[]{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0};
            cruza.cruzaXMascara(mascara, madre, padre);
            System.out.println("\n");
           
//        Herramientas.leerDatos(new int[]{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0});

          Herramientas.leerDatos(cruza.cruzaPorMascara(mascara, madre, padre));
        
        MinimaDistancia md = new MinimaDistancia(Herramientas.instancias.size());
        md.entrenar(Herramientas.instancias);
        md.clasificar(Herramientas.instancias);
        System.out.println(md.getMc().toString());
        AnalisisResultado ar = new AnalisisResultado(Herramientas.instancias);
     
        System.out.println((ar.getGood()*100)/178+"%");
       }
//        for(int i=0; i<15;i++){
//            System.out.print(""+cruza.hijo1[i]);
//        }

//        Knn knn = new Knn(4);
//        knn.entrenar(Herramientas.instancias);
//        knn.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
//        System.out.println(knn.getMc().toString());
        
    }
    
}
