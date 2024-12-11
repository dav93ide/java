package veicoli;

public class MainVeicoli {

    public static void main(String[] args) {
        AcquaScooter AS = new AcquaScooter("YoYo");
        Jet J = new Jet("YeahYeah");
        System.out.println("Matricola Dell'Acquascooter: " + AS.getTarga());
        System.out.println("Matricola Del Jet: " + J.getTarga());
        
    }
    
}
