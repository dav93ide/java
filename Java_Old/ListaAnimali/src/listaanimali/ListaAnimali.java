package listaanimali;
import java.util.Scanner;

public class ListaAnimali {

    public static void main(String[] args) {
        int i;
        String sTipo, sNome;
        Animale[] listAnimals = new Animale[9];         //Lista di oggetti di superclasse Animale
        Scanner input = new Scanner(System.in);
        for (i=0; i<=4; i++){
            System.out.println("Inserire tipo di animale");
            sTipo=input.nextLine();
            System.out.println("Inserire nome animale");
            sNome = input.nextLine();
            
            if(sTipo.equals("cane"))                    // Creo sottoclasse in base a sTipo
                listAnimals[i] = new Cane(sNome);       // Inizializzo la posizione "i" dell'array
            else if(sTipo.equals("gatto"))              // listAnimals con l'oggetto creato
                listAnimals[i] = new Gatto(sNome);
            else if(sTipo.equals("topo"))
                listAnimals[i] = new Topo(sNome);  
        }
        
        for(i=0;i<=4;i++){
            listAnimals[i].nome();          //Polimorfismo su metodo nome()
            listAnimals[i].verso();         //Polimorfismo su metodo verso()
        }
    }
    
}
