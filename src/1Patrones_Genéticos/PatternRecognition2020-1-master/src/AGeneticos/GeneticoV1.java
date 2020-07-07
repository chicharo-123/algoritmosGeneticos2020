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

public class GeneticoV1{

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public GeneticoV1(int num_G,double pMuta,int tamPob){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la poblaciÃ³n inicial como aleatoria
        this.pobActual = new Poblacion(tamPob);

    }

    public void evolucionar(){
        int mascara [] = new int[]{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0};
        // proceso evolutivo donde se generan nuevas poblaciones
        AIndividuo mejor;
        for(int g=0; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            // se agregan los individuos de la poblaciÃ³n
            mejor = new AIndividuo(new int[14]);
            for(int i=0; i<this.tamPob;i++){
                // proceso de SelecciÃ³n
                AIndividuo madre = new AIndividuo(new int[14]);
                AIndividuo padre = new AIndividuo(new int[14]);
                // proceso de Cruza
                AIndividuo hijo = cruza.cruzaXMascara(mascara, madre, padre);
                // proceso de MutaciÃ³n
            
                if(Math.random()<this.pMuta){
                    Muta.aplicarMutaAleatoria(hijo);
                    // mutar por referencia al hijo
                }
                // el hijo generado se agregar a la nueva poblaciÃ³n
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness()>mejor.getFitness()){
                    mejor = new AIndividuo(hijo.getGenotipo());
                }
            }
            System.out.println("G"+g+"-"+mejor.toString());
            // actualizar la poblaciÃ³n actual 
            this.pobActual = new Poblacion(nueva);

        }
        System.out.println();

    }


}
