package vettoreanimali;
import java.util.Scanner;

public class VettoreAnimali {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire Numero Di Animali");
        Animali animals = new Animali(input.nextInt());
        for(int i=0; i<animals.getLenVet();i++){
            String sName,sVerso;
            System.out.println("Inserire Nome Animale "+ (i+1));
            sName = input.nextLine();
            System.out.println("Inserire Verso Animale "+ (i+1));
            sVerso = input.nextLine();
            animals.setNomeEVerso(i, sName, sVerso);
        }
        for(int i=0; i<animals.getLenVet();i++){
            System.out.println((i+1)+"] "+ animals.getNomeEVerso(i));
        }
        System.out.println("\n\nFine Programma\n\n");
    }
    
}
