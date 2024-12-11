/*

    Un Po' Fatto Alla Cazzo, Ricontrollarlo E Farlo Meglio!!

*/


package aziendaautovetture;

public class AziendaAutovetture {

    public static void main(String[] args) {
        Furgoncino f1 = new Furgoncino("Fiat", "Boh" , "CDOOD", 10,10,10,5);
        Furgoncino f2 = new Furgoncino("Fiat", "Boh" , "555CD", 10,10,10);
        Furgoncino f3 = new Furgoncino("Fiat", "Boh" , "AQWLO", 10,10,10,6);
        Pulmino p1 = new Pulmino("Fiat", "Mah" , "QOEP",10,0);
        Pulmino p2 = new Pulmino("Fiat", "Mah" , "ADQOPC",5,10);
        Dipendenti d1 = new Dipendenti("LNEEEO", "Caio", "Chennesso", 'D');
        Dipendenti d2 = new Dipendenti("L!ASDF", "Beppe", "Chennesso", 'C');
        Dipendenti d3 = new Dipendenti("QWDASV", "Toni", "Chennesso", 'B');
        
        f1.noleggiaVeicolo(d3);
        if(f1.ctrNA()) d1.Noleggia(f1);
        f2.acquista(d2);
        if(f2.ctrNA()) d2.Noleggia(f2);
        p1.noleggiaVeicolo(d2);
        if(p1.ctrNA()) d2.Noleggia(f1);
        p2.noleggiaVeicolo(d3);
        if(p2.ctrNA()) d3.Noleggia(p2);
        f3.noleggiaVeicolo(d2);
        if(f3.ctrNA()) d2.Noleggia(f3);
        
        f1.getNoleggiato();
        f1.getAcquistato();
        f2.getAcquistato();
        f2.getNoleggiato();
        f3.getAcquistato();
        f3.getNoleggiato();
        p1.getNoleggiato();
        p1.getAcquistato();
        p2.getAcquistato();
        p2.getNoleggiato();
        
        
    }
    
}
