package enumproject;

public class EnumProject {

    public static void main(String[] args) {
        
        Vets vet = new Vets();
        vet.printVets();
        
        Enum enumMesi = null;
        System.out.println("In Un Anno Ci Sono: "+enumMesi.GENNAIO.getGiorniAnno()+" Giorni");
        Chess enumChess = null;
        System.out.println("Numero Totale Di Pezzi Nella Scacchiera:" +enumChess.PEDONE.getNTotPezzi());
        
    }
    
}
