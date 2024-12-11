//SAVIAN DAVIDE
package aziendamagazzini;
import java.util.Random;

public class magazzino {
    private String nome = new String();
    private double larghezza;
    private double lunghezza;
    private int merciA;
    private int merciB;
    private int puntoRiordinoA;
    private int puntoRiordinoB;
    Random rand = new Random();
    
    public magazzino(){
        larghezza = 100;
        lunghezza = 100;
        merciA=0;
        merciB=0;
        nome = "Magazzino_1";
        puntoRiordinoA = 50;
        puntoRiordinoB = 50;
        System.out.println("New// Creato Oggetto -> Magazzino " + nome);
    }
    public magazzino(String name,double lun, double lar){
        nome = name;
        lunghezza = lun;
        larghezza = lar;
        puntoRiordinoA = 50;
        puntoRiordinoB = 50;
        merciA=0;
        merciB=0;
        System.out.println("New// Creato Oggetto -> Magazzino " + name);
    } 
    public magazzino(String name,double lun, double lar, int pointA, int pointB){
        nome = name;
        lunghezza = lun;
        larghezza = lar;
        puntoRiordinoA = pointA;
        puntoRiordinoB = pointB;
        merciA=0;
        merciB=0;
        System.out.println("New// Creato Oggetto -> Magazzino " + name);
    }
    public void setDim(double lun,double lar){
        lunghezza = lun;
        larghezza = lar;
    }
    public void setPuntoRiordino(int pointA, int pointB){
        puntoRiordinoA = pointA;
        puntoRiordinoB = pointB;
    }
    public void caricaMerci(int merceA, int merceB){
        merciA=merceA;
        merciB=merceB;
        System.out.println("\nDeposito// Quantitativo Di Merce A Depositata: "+ merceA + " Unità, Merce B: "+ merceB + " Unità.");
    }
    public void infoMagazzino(){
        System.out.println("\nInfo// Quantitativo Di Merce Di Tipo A Rimasto: "+ merciA + " unità.\n");
        if(merciA>puntoRiordinoA){
            System.out.println("Info// Risulta Necessario Riordinare La Merce Di Tipo A. \n");
            this.setPuntoRiordino((puntoRiordinoA+(merciA-puntoRiordinoA)), puntoRiordinoB);    // Per Non Visualizzare Sempre "Necessario Riordinare Merce" Risetto Automaticamente PuntoRiordinoA Aggiungendogli La MerceA In Surplus. 
        }                                                                                  // (Potevo Settare Direttamente La Variabile Ma Ho Preferito Utilizzare Il Metodo Apposito).
        System.out.println("Info// Quantitativo Di Merce Di Tipo B Rimasto: "+ merciB + " unità. \n");
        if(merciB>puntoRiordinoB){
            System.out.println("Info// Risulta Necessario Riordinare La Merce Di Tipo B. \n");
            this.setPuntoRiordino(puntoRiordinoA,(puntoRiordinoB+(merciB-puntoRiordinoB)));     // Risetto puntoRiordinoB
        }                                                                                  
    }
    public void prelievoMerce(char tipo,int qnt){
        if(tipo=='A'){
            if(qnt<merciA){
                System.out.println("\nPrelievo// Ritirato Un Quantitativo Di: "+ qnt + " Unità Di Merce Di Tipo: "+ tipo+".");
                merciA-=qnt;
                this.setPuntoRiordino((puntoRiordinoA-qnt),puntoRiordinoB);  // Tolgo A Punto Di RiordinoA La Merce Ritirata Per Visualizzare "Necessario Riordinare Merce" Appena Si Effettua Un Deposito
                this.infoMagazzino();
            }
            else{
                System.out.println("Prelievo// Quantitativo Di Merce Di Tipo: "+tipo+" Rimasto Non Sufficiente, Mancano " + (qnt-merciA) + " Unità.");
            }
        }
        else{
            if(qnt<merciB){
                System.out.println("\nPrelievo// Ritirato Un Quantitativo Di: "+ qnt + " Unità Di Merce Di Tipo: "+ tipo+".");
                merciB-=qnt;
                this.setPuntoRiordino(puntoRiordinoA,(puntoRiordinoB-qnt)); // Tolgo A Punto Di RiordinoB La Merce Ritirata
                this.infoMagazzino();
            }
            else{
                System.out.println("Prelievo// Quantitativo Di Merce Di Tipo: "+tipo+" Rimasto Non Sufficiente, Mancano " + (qnt-merciB) + " Unità.");
            }
        }
    }
    public void densitàMerci(){
        double densità,area;
        densità=(double) (merciA+merciB);   // Faccio Il Cast Da Int A Double Della Somma Delle Merci
        area = larghezza * lunghezza;
        densità*=area;
        System.out.println("\nDensità// La Densità Complessiva Delle Merci A e B In Un Area Di: "+ area + " m^2 Corrisponde A: "+densità+" kg/m^2.");
    }
    public void deperimentoMerci(){
        int depA,depB;
        do{
            depA = rand.nextInt(11);              // Ho Provato Ad Utilizzare rand.ints(origin,bound) Ma Dava Un Errore Di Incopatibilità Di Tipo 
            depB = rand.nextInt(11);              // Poiché Ritorna Uno Stream Di Int (Da Quel Che Ho Capito), Anche Utilizzando Un Cast Dava Errore 
        } while ((depA<=2)||(depB<=2));                // Dunque Ho Utilizzato Il Metodo rand.nextInt(bound) con Origin Inclusiva = 0 e Bound Esclusivo 
        merciA-=(merciA*depA)/100;                // Inserito Dall'utente; Successivamente Con Un Ciclo Do-While Ho Imposto L'origine Di Entrambi
        merciB-=(merciB*depB)/100;                // I Valori Casuali >= A 2.
        System.out.println("\nDeperimento// A Causa Del Deperimento Della Merce Sono Stati Perse "+ ((merciA*depA)/100)
                + " Unità Di Merce Tipo A E "+ ((merciB*depB)/100) +" Unità Di Merce Tipo B" );
        System.out.println("RAND A : "+ depA + " RAND B: " + depB );
        this.infoMagazzino();
    }
}
