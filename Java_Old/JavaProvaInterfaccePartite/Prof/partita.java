
package pkg15_sport;

import java.util.Scanner;

public interface partita {
    
    void getRisultato ();
    
}

//CLASSE ASTRATTA Abspartita, per tutte le partite
//ha il metodo per leggere le squadre, per stampare il risultato
//per fissare il risultato (che verrà passato dalle classi figlie)

abstract class Abspartita {
    private int ris_casa;
    private int ris_trasferta;
    private String sq_casa;
    private String sq_trasferta;
    public Scanner sc = new Scanner(System.in);
    
    public void getSquadre () {
        System.out.println("Inserire la squadra in casa");
        sq_casa = sc.next();
        System.out.println("Inserire la squadra in trasferta");
        sq_trasferta = sc.next();        
    }            

    public void PrintRisultato () {
        System.out.println(this.getClass().getSimpleName() + 
                            " Risultato Finale: " + sq_casa + "-" + sq_trasferta + ": " + 
                            ris_casa + "-" + ris_trasferta );        
    }        
    
    public void SetRisultato (int r1, int r2) {
        ris_casa = r1;
        ris_trasferta = r2;
    }
    
}

//CLASSE ASTRATTA AbspartitaTempi, per tutte le partite con risultato = somma dei tempi
//metodi per settare il numero dei tempi, per avere il parziale di una squadra in un tempo
//e metodo per calcolare il risultato (è QUELLO DELL'INTERFACCIA!!) 
abstract class AbspartitaTempi extends Abspartita implements partita {
    private int ntempi;
    
    public void settempi (int n) {
        ntempi = n;
    }

    public int getParziale(int i, String s) {
        int r;
        System.out.println("Tempo " + i + " Punteggio squadra di " + s);
        r = sc.nextInt();   
        return r;
    }
        
    public void getRisultato() {
        int i, r1 = 0, r2 = 0;
        System.out.println("INSERIMENTO RISULTATO");
        
        for (i=1; i<=ntempi; i++) {
            r1+=getParziale(i, "casa");
            r2+=getParziale(i, "trasferta");
        }

        SetRisultato(r1, r2);
        PrintRisultato();
    }        
    
}

class PCalcio extends AbspartitaTempi {
        
    public PCalcio() {
        System.out.println("CALCIO: INSERIMENTO SQUADRE");
        getSquadre();
        super.settempi(2);
    }
        
}

class PBasket extends AbspartitaTempi {
    
    public PBasket() {   
        System.out.println("BASKET: INSERIMENTO SQUADRE");
        getSquadre();
        super.settempi(4);
    }

}

class PPallanuoto extends AbspartitaTempi {
    
    public PPallanuoto() {   
        System.out.println("PALLANUOTO: INSERIMENTO SQUADRE");
        getSquadre();
        super.settempi(3);
    }
        
}

