package provainterfaccia2;
import java.util.Scanner;

public class ProvaInterfaccia2 {

   
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Calcio calcio = new Calcio(2);
        Pallanuoto pallanuoto = new Pallanuoto(3);
        Basket basket = new Basket(4);
        System.out.println("Inserire Numero Set Di Tennis");
        int tTennis = input.nextInt();
        Tennis tennis = new Tennis(tTennis);
        String s1,s2;
        System.out.println("Inserire Nomi 2 Squadre Di Calcio");
        s1 = input.nextLine();
        s2 = input.nextLine();
        calcio.setSquadre(s1, s2);
        System.out.println("Inserire Nomi 2 Squadre Di Pallanuoto");
        s1 = input.nextLine();
        s2 = input.nextLine();
        pallanuoto.setSquadre(s1, s2);
        System.out.println("Inserire Nomi 2 Squadre Di Basket");
        s1 = input.nextLine();
        s2 = input.nextLine();
        basket.setSquadre(s1,s2);
        System.out.println("Inserire Nomi 2 Squadre Di Tennis");
        s1 = input.nextLine();
        s2 = input.nextLine();
        tennis.setSquadre(s1, s2);
        int p1,p2;
        for(int i=0;i<2;i++){
            System.out.println("Inserire Punteggio Della Prima Squadra Di Calcio Nel " + (i+1) + "nd Tempo");
            p1 = input.nextInt();
            System.out.println("Inserire Punteggio Della Seconda Squadra Di Calcio Nel " + (i+1) + "nd Tempo");
            p2 = input.nextInt();
            calcio.setRisultato(p1,p2);
        }
        for(int i=0;i<3;i++){
            System.out.println("Inserire Punteggio Della Prima Squadra Di Pallanuoto Nel " + (i+1) + "nd Tempo");
            p1 = input.nextInt();
            System.out.println("Inserire Punteggio Della Seconda Squadra Di Pallanuoto Nel " + (i+1) + "nd Tempo");
            p2 = input.nextInt();
            pallanuoto.setRisultato(p1,p2);
        }
        for(int i=0;i<4;i++){
            System.out.println("Inserire Punteggio Della Prima Squadra Di Basket Nel " + (i+1) + "nd Tempo");
            p1 = input.nextInt();
            System.out.println("Inserire Punteggio Della Seconda Squadra Di Basket Nel " + (i+1) + "nd Tempo");
            p2 = input.nextInt();
            basket.setRisultato(p1,p2);
        }
        for(int i=0;;i++){
            System.out.println("Inserire Punteggio Del Primo Giocatore Di Tennis Nel " + (i+1) + "nd Set");
            p1 = input.nextInt();
            System.out.println("Inserire Punteggio Del Secondo Giocatore Di Tennis Nel " + (i+1) + "nd Set");
            p2 = input.nextInt();
            if(basket.setRisultato(p1,p2));
            else break;
        }
        calcio.getWinner();
        pallanuoto.getWinner();
        basket.getWinner();
        tennis.getWinner();
        calcio.getRisultati();
        pallanuoto.getRisultati();
        basket.getRisultati();
        tennis.getRisultati();
        
    }
    
}
