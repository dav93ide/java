/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometria;

/**
 *
 * @author biagiorosariogreco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto P = new Punto(10.25);
        Punto P1 = new Punto(13.25, 14.25);
        System.out.println(
                P + "\n" +
                P1 +
                "\n la distanza vale: " +
                P.dist(P1) + "\n" +
                P1.dist(P));
        Cerchio C0;
        
    }
    
}
