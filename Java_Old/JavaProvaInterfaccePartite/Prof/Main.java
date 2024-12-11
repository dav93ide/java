/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15_sport;

public class Main {

    public static void main(String[] args) {
        partita p;
      
        PCalcio pc = new PCalcio();
        
        p = pc;        
        p.getRisultato();   

        PBasket pb = new PBasket();
        
        p = pb;
        p.getRisultato();

        PPallanuoto pp = new PPallanuoto();
        
        p = pp;
        pp.getRisultato();
        
    }
    
}
