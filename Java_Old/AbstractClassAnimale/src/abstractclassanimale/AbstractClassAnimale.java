package abstractclassanimale;


public class AbstractClassAnimale {

    public static void main(String[] args) {
        Pesci fish = new Pesci(0,"Carnivoro","Squalo");
        Uccelli bird = new Uccelli(2,"Onnivoro","Pettirosso");
        Mammiferi cat = new Mammiferi(4,"Onnivoro","Gatto");
        System.out.println("Specie: -" + fish.getSpecie() + "- Alimentazione: -"+fish.getAlimentazione() + "- Numero Gambe: -" + fish.getNumZampe()+"-");
        System.out.println("Specie: -" + bird.getSpecie() + "- Alimentazione: -"+bird.getAlimentazione() + "- Numero Gambe: -" + bird.getNumZampe()+"-");
        System.out.println("Specie: -" + cat.getSpecie() + "- Alimentazione: -"+cat.getAlimentazione() + "- Numero Gambe: -" + cat.getNumZampe()+"-");
    }
    
}
