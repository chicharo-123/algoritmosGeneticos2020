/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresSat;


/**
 *
 * @author cesar
 */
public class Main {
      public static void main(String[] args) {

        Tokenizer.leerDatos();
        GeneticoTresSat gen = new GeneticoTresSat(500000, 5, 0.33,5);
        gen.evolucionar();
        System.out.println();
    }
}
