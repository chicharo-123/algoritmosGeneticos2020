/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import tsp.cruza;

/**
 *
 * @author Don Gary
 */
public class geneticoV2 {
    
    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public geneticoV2(int num_G,double pMuta,int tamPob, int ci, int n){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la poblaciÃ³n inicial como aleatoria
        this.pobActual = new Poblacion(tamPob, ci ,n);

    }

    public void evolucionar(){
      
        // proceso evolutivo donde se generan nuevas poblaciones
        Individuo mejor = null;
        Individuo mj = null;
        
        
        for(int g=1; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            // se agregan los individuos de la poblaciÃ³n
            
            for(int i=0; i<this.tamPob;i++){
                // proceso de SelecciÃ³n


            Individuo madre = seleccion.seleccionAleatoria(this.pobActual);
            Individuo padre = seleccion.seleccionAleatoria(this.pobActual);
                // proceso de Cruza
//                Individuo hijo1 = cruza.Asexual(mascara, madre, madre);
//                Individuo hijo2 = cruza.Asexual(mascara, padre, padre);
                Individuo hijo1 = cruza.Asexual(padre, madre);
                Individuo hijo2 = cruza.Asexual(padre, padre);
                // proceso de MutaciÃ³n
            
                if(Math.random()<this.pMuta){
                   muta.mutaGen(pMuta,hijo1);
                   muta.mutaGen(pMuta,hijo2);
                    // mutar por referencia al hijo
                }
               // el hijo generado se agregar a la nueva poblaciÃ³n
                nueva.getPoblacion().add(hijo1);
                  nueva.getPoblacion().add(hijo2);
                
                if (hijo1.getFitness()<hijo2.getFitness()){
                    mejor = new Individuo(hijo1.getGenotipo());
                    mj = new Individuo(hijo1.getGenotipo());
                }
            }
           // System.out.println("///////////////////////////////////////////////////////");

            for(int y=0; y<mejor.getGenotipo().length; y++)
               System.out.print(" "+mj.getGenotipo()[y]);

            System.out.println("G"+g+"-"+mejor.toString());
            // actualizar la poblaciÃ³n actual 
            this.pobActual = new Poblacion(nueva);

                
            }
            
                System.out.println();
                
                guardarYalmacenar(mj.getGenotipo()[0],mj.getGenotipo().length,mj);
        }
        
public void guardarYalmacenar(int ci, int n, Individuo I){
    
    String temp ="";
//    int [] matriz = null;
//    for(int i = 0;i<n; i++){
//        matriz[i]=I.getGenotipo()[i];
//    }
    temp = temp + "Ciudades: " + n+ "\n Ci: " + ci + "\n Fitness: " + I.getFitness() + "  \n Genotipo: "+ I.getGenotipo()[0]+","+I.getGenotipo()[1]+","+I.getGenotipo()[2]+","+I.getGenotipo()[3]+","+I.getGenotipo()[4]+","+I.getGenotipo()[5]+","+I.getGenotipo()[6]+","+I.getGenotipo()[7]+","+I.getGenotipo()[8]+","+I.getGenotipo()[10]+","+I.getGenotipo()[11]+","+I.getGenotipo()[12]+","+I.getGenotipo()[13]+","+I.getGenotipo()[14]+","+I.getGenotipo()[15]+","+I.getGenotipo()[16]+","+I.getGenotipo()[17]+","+I.getGenotipo()[18]+","+I.getGenotipo()[19]+","+I.getGenotipo()[20]+","+I.getGenotipo()[21]+","+I.getGenotipo()[22]+","+I.getGenotipo()[23]+","+I.getGenotipo()[24]+","+I.getGenotipo()[25]+","+I.getGenotipo()[26]+","+I.getGenotipo()[27]+","+I.getGenotipo()[28]+","+I.getGenotipo()[29]+","+I.getGenotipo()[30]+","+I.getGenotipo()[31]+","+I.getGenotipo()[32]+","+I.getGenotipo()[33]+","+I.getGenotipo()[34]+","+I.getGenotipo()[35]+","+I.getGenotipo()[36]+","+I.getGenotipo()[37]+","+I.getGenotipo()[38]+","+I.getGenotipo()[39]+","+I.getGenotipo()[40]+","+I.getGenotipo()[41]+","+I.getGenotipo()[42]+","+I.getGenotipo()[43]+","+I.getGenotipo()[44]+","+I.getGenotipo()[45]+","+I.getGenotipo()[46]+","+I.getGenotipo()[47]+","+I.getGenotipo()[48]+","+I.getGenotipo()[49]+","+I.getGenotipo()[50]+","+I.getGenotipo()[51]+","+I.getGenotipo()[52]+","+I.getGenotipo()[53]+","+I.getGenotipo()[54]+","+I.getGenotipo()[55]+","+I.getGenotipo()[56]+","+I.getGenotipo()[57]+","+I.getGenotipo()[58]+","+I.getGenotipo()[59]+","+I.getGenotipo()[60]+","+I.getGenotipo()[61]+","+I.getGenotipo()[62]+","+I.getGenotipo()[63]+","+I.getGenotipo()[64]+","+I.getGenotipo()[65]+","+I.getGenotipo()[66]+","+I.getGenotipo()[67]+","+I.getGenotipo()[68]+","+I.getGenotipo()[69]+","+I.getGenotipo()[70]+","+I.getGenotipo()[71]+","+I.getGenotipo()[72]+","+I.getGenotipo()[73]+","+I.getGenotipo()[74]+","+I.getGenotipo()[75]+","+I.getGenotipo()[76]+","+I.getGenotipo()[77]+","+I.getGenotipo()[78]+","+I.getGenotipo()[79];
       

        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
         try{
        f=new File("i_1000_997.txt");
        w = new FileWriter(f, true);
        bw=new BufferedWriter(w);
        wr=new PrintWriter(bw);
        
        wr.write(temp);
        bw.close();
        w.close();
        
        }catch(IOException e){
            e.printStackTrace();
           
        }
}
    }


