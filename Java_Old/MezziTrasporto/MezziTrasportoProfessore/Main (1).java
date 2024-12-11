/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg16_mezzitrasporto;

/**
 *
 * @author adrianobotteon
 */
public class Main {

    public static void main(String[] args) {
        impiegato i1 = new impiegato (12345, "mario", "bordi", true, false, false);
        impiegato i2 = new impiegato (23456, "anna", "gigli", true, true, false);
        impiegato i3 = new impiegato (34567, "davide", "gugli", true, true, true);
        
        autovettura a = new autovettura ("Fiat", "Panda", "2343243");
        pulmino p = new pulmino ("Fiat", "PulPul", "2343243", 15);
        furgoncino f = new furgoncino ("Fiat", "Ducato", "2423432", 125, 200, 230);
        
        a.assegna(i1);
        a.restituisci(20);
        p.assegna(i1);
        p.assegna(i2);
        p.restituisci(200);
        f.assegna(i3);
        f.restituisci(15);
    }
    
}
