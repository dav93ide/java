package tavolaelementi;

public class TavolaElementi {

    public static void main(String[] args) {
        for(EnumElementi iter : EnumElementi.values()){
            System.out.println("Sigla Elemento: " + iter.name() + " \n\tNome Completo: " + iter.getNameElement() + " Numero Atomico: " + iter.getNumeroAtomico() + " Massa Atomica: " + iter.getMassaAtomica());
        }
    }
    
}
