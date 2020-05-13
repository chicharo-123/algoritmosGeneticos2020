
package Reinas;

import java.util.Random;
/**
 *
 * @author cesar
 */
public class Individuo {
    
    private int genotipo[];
    private int fitness;
    private int n;
    
      public int[] getGenotipo() {
        return genotipo;
    }
    public int getFitness() {
        return fitness;
    }
    
     public int getN() {
        return n;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void setN(int n) {
        this.n = n;
    }
  public void actualizarIndividuo(){
      calcularFitness();
  }
  //creamos constructor de genotipo dado por nosotros
    public Individuo(int genotipo[]){
         this.n = genotipo.length;
         this.genotipo = genotipo.clone();
         calcularFitness();
    }
      //creamos constructor del geno aleatorio
    public Individuo(int n) {
        this.n = n;
        this.genotipo = GenotipoAleatorio();
         calcularFitness();
    }
    //creamos el genotipo aleatorio
    private int[] GenotipoAleatorio() {
        int aux [] = new int[this.n];
        Random ran = new Random();
        for(int x=0; x<aux.length;x++)
            aux[x]= ran.nextInt(this.n);
        return aux;
    }
  //calculamos fitnes
    private void calcularFitness() {
       this.fitness = 0;
      // recorremos el genotipo para poder calcular los ataques
      for(int x=0;x<this.n-1;x++){
          for(int y=x+1;y<this.n;y++){
      // checamos donde se atacan y los acumulamos
         int actx = this.genotipo[x];
         int acty = this.genotipo[y];
         int aux_1 = this.genotipo[x]-x;
         int aux_2 = this.genotipo[y]-y;
          int aux2x = this.genotipo[x]+x;
              int aux2y = this.genotipo[y]+y;
              if(actx==acty||aux_1==aux_2||aux2x==aux2y){
                  this.fitness+=2;
              }
          }
       }
      System.out.println(this.fitness);
            
    }
    
//4 8 7 20 80 100
}
