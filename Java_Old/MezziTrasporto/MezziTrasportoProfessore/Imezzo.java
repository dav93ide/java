
package pkg16_mezzitrasporto;

public interface Imezzo {
    public void assegna (impiegato imp);
    public void restituisci (int ikm);    
}

abstract class mezzo implements Imezzo {
    String casa;
    String modello;
    String targa;
    int nkm;
    impiegato imp_ass;
    
    public mezzo(String c, String m, String t) {
        casa = c;
        modello = m;
        targa = t;
        nkm = 0;
    }

    public mezzo(String c, String m, String t, int kminiz) {
        casa = c;
        modello = m;
        targa = t;
        nkm = kminiz;
    }
        
    public void assegna (impiegato imp) {
        imp_ass = imp;
        System.out.println("Mezzo " + casa + " " + modello + " assegnato a " + imp.cognome);
    }

    public void restituisci (int ikm) {
        imp_ass = null;
        nkm += ikm;
        System.out.println("Mezzo " + casa + " " + modello + " restituito");
    }
        
}

class autovettura extends mezzo {
    public autovettura (String c, String m, String t) {
        super(c, m, t);
    }
}

class furgoncino extends mezzo {
    int altezza, larghezza, profondita;
    
    public furgoncino (String c, String m, String t, int alt, int larg, int prof) {
        super(c, m, t);
        altezza = alt;
        larghezza = larg;
        profondita = prof;
    }

    public void assegna (impiegato imp) {
        if (imp.patC) {
            super.assegna(imp);            
        }
        else 
            System.out.println("Impiegato " + imp.cognome + " senza patente C");
    }
            
}

class pulmino extends mezzo {
    int nposti;
    
    public pulmino (String c, String m, String t, int np) {
        super(c, m, t);
        nposti = np;
    }

    public void assegna (impiegato imp) {
        if ((imp.patD) && (nposti > 9))
            super.assegna(imp);
        else 
            System.out.println("Impiegato " + imp.cognome + " senza patente D");
        
    }

        
}
