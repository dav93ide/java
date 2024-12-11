package aziendaautovetture;

public class Dipendenti implements Noleggio{
    
    private String matrix;
    private String name;
    private String surname;
    private char patente;
    private int kmPercorsi;
    private AMezzoTrasporto T;
    
    public Dipendenti(String matricola, String name, String surname, char patente){
        this.matrix = matricola;
        this.name = name;
        this.surname = surname;
        this.patente = patente;
    }
    
    public Dipendenti(String matricola,String name,String surname){
        this(matricola,name,surname,'/');
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public char getPatente(){
        return this.patente;
    }
    
    public void setKm(int kmPercorsi){
        this.kmPercorsi = kmPercorsi;
    }
    
    public int getKm(){
        return kmPercorsi;
    }
    
    public void Noleggia(AMezzoTrasporto T){
        this.T = T;
    }
    
    @Override
    public void getNoleggiato(){
        T.getNoleggiato();
    }
    
    @Override
    public void getAcquistato(){
        T.getAcquistato();
    }
    
    @Override
    public void restituisci(){
        this.T = null;
        kmPercorsi = 0;
    }
}
