
package distributorebenzina;

public class Distributore {
    private double deposito;
    private double euroPerLitro;
    
    public void rifornimento(double litri){
    deposito += litri;
}
    public double vendiBenzina(double euro){
        double n;
        n = euro/euroPerLitro;
        if(n>deposito){
            System.out.println("\nNon E' Stato Possibile Effettuare L'operazione Poiché I Litri In Deposito Non Sono Sufficienti.");
            n=0;
        }
        else{
        deposito -= (euro/euroPerLitro); 
        System.out.println("\nRiforniti nella vettura " + n + " litri");
        }
        return n;
    }
    
    public void infoDistributore(){
        System.out.println("\nPrezzo Attuale Benzina: " + euroPerLitro + " Euro al litro, litri di benzina in deposito: " + deposito);
    }
    
    public void cambioPrezzo(double euro){
        System.out.println("\nVecchio Prezzo Al Litro Benzina :" + euroPerLitro +"Euro, Nuovo Prezzo Benzina: " + euro + " Euro.");
        euroPerLitro= euro;
        System.out.println("\nModifica Effettuata.");
    }
    
    public Distributore(double euro){
        euroPerLitro= euro;
        deposito= 0.0;
    }
    public Distributore(){
        euroPerLitro=0.0;
        deposito= 0.0;
    }
    
}
