package giornomeseanno;



public class Calendario {
    int giorno;
    int mese;
    int anno;
    
   
    public Calendario(){
        giorno = 1;
        mese = 1;
        anno = 2015;
    }
    public Calendario(int giorno, int mese, int anno){
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }
    public Calendario(Calendario gg_mm_aaaa){      //Costruttore di copia.
        this.giorno = gg_mm_aaaa.giorno;
        this.mese = gg_mm_aaaa.mese;
        this.anno = gg_mm_aaaa.anno;
    }
    @Override
    public String toString(){
        //return giorno+"/"+mese+"/"+anno;
        /*      
        if(<CONDIZIONE>)
            <then-statement>
        else
            <else-statement>
        
        ((<CONDIZIONE) ? <THEN-STATEMENT> : <ELSE-STATEMENT>)
        */        
        //return((giorno<10) ? "0" + giorno : giorno ) + "/" + ((mese<10) ? "0" + mese : mese) + "/" + anno;
        return((giorno < 10) ? "0" : "") + giorno + "/" + ((mese < 10) ? "0" : "") + mese + "/" + anno;
    }
    public int getGiorno(){
        return giorno;
    }
    public int getMese(){
        return mese;
    }
    public int getAnno(){
        return anno;
    }
    public void setGiorno(int day){
        giorno = day;
    }
    public void setMese(int month){
        mese = month;
    }
    
    /***
     * Questo metodo setta l'anno;
     * anno è definito come membro privato
     * per cui creo per essa delle funzioni
     * di get e di set
     * @param anno che rappresenta il mese da 0 a 12
     * @return non ritorna nessun parametro
     * @see guarda get mese getMese
     ***/
    public void setAnno(int year){
        anno = year;
    }
    /***
     * Questo metodo ci porta un giorno avanti o un giorno indietro,
     * accetta come parametri anche interi negativi; in base a quei valori
     * la mia data si sposterà in avanti o indietro del numero di giorni
     * indicato.
     * @param day
     * @see set giorno()
     */
    public void goDay(int day){
        giorno+=day;
    }
    
}
