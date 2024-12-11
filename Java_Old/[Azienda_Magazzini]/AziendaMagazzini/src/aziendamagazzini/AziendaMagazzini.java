//SAVIAN DAVIDE
package aziendamagazzini;

public class AziendaMagazzini {

    public static void main(String[] args) {
        
        magazzino magCen = new magazzino ("Centrale", 100,120);
        magCen.setPuntoRiordino(40,30);
        magCen.caricaMerci(100,120);
        magCen.prelievoMerce('B',30);
        magCen.prelievoMerce('B',20);
        //magCen.infoMagazzino(); -> Non Necessario Poiché In Metodo prelievoMerce() Viene Richiamato Alla Fine
        magCen.prelievoMerce('A',60);
        magCen.densitàMerci();
        magCen.prelievoMerce('A',20);
        //magCen.infoMagazzino(); 
        magCen.deperimentoMerci(); 
        //magCen.infoMagazzino();
    }
    
}
