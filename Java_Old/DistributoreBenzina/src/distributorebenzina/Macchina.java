
package distributorebenzina;

public class Macchina {
    private String targa;
    private double serbatoio;
    
    public Macchina(String str){
        targa= str;
        serbatoio=10;
    }
    
    public void setTarga(String str){
        targa= str;
    }
    public void setSerbatoio(double litri){
        serbatoio=litri;
    }
    public void rifornimento(Distributore d,double euro){
        serbatoio += d.vendiBenzina(euro);    
    }
    public void getInfo(){
        System.out.println("Targa: "+ targa + " Serbatoio: "+ serbatoio+" litri.");
    }
}
