
package aereoporto;


public class utente {
    String status;
    String nome;
    String cognome;
    String passwordDecrypted;
    String passwordEncrypted;
    int idUtente;
    int[] idPrenotazione;
    int[] postiPrenotati;
    
    public utente(){
        status = "Guest";
        nome = "Guest";
        cognome = "Guest";
        passwordDecrypted="Null";
        passwordEncrypted="Null";
        idPrenotazione= new int[20];
        postiPrenotati= new int[20];
    }
    
    @Override
    public String toString(){
        return new String(
            String.valueOf(idUtente) + "~" +
            nome + "~" +
            cognome + "~" +
            passwordEncrypted + "~");
    }
    
    public void printPrenotazioni(airportFileHandler handler){
        String ID="";
        for(int i=0;idPrenotazione[i]!=0;i++){
            ID=handler.getIdVoloPrenotation(idPrenotazione[i]);
            System.out.println(
                    (i+1) + "] Prenotazione ~ " +
                    "ID: "+ idPrenotazione[i] +
                    "Posti Prenotati: "+ postiPrenotati[i] +
                    "ID Del Volo: " + ID +
                    ".");
        }
        if(ID.isEmpty()){
            System.out.println("Nessuna Prenotazione");
        }
    }
    
    public void logOut(){
        status = "Guest";
        nome = "Guest";
        cognome = "Guest";
        passwordDecrypted="Null";
        passwordEncrypted="Null";
    }
    
    public String makePrenotation(int nPosti,String idVolo, airportFileHandler handler){
        String idNewPrenotation;
        idNewPrenotation = String.valueOf((handler.getLastPrenotation() + 1));
        return new String(
                "/" +
                idUtente + "~" +
                idNewPrenotation + "~" +
                String.valueOf(nPosti) + "~" +
                idVolo + "~");
    }
    
    private String passwordEncryption(String passDe){
        String passEn="";
        String strTemp;
        int Ascii;
        for(int i=0; i < passDe.length(); i++){
            Ascii = ((int)passDe.charAt(i))+23;
            if(Ascii<10){
                strTemp= "0"+"0"+ String.valueOf(Ascii);
            }
            else{
                if(Ascii<100){
                    strTemp= "0"+String.valueOf(Ascii);
                }
                else{
                    strTemp=String.valueOf(Ascii);                    
                }
            }
            passEn+=strTemp;
        }
        return passEn;
    }
    
    private String passwordDecryption(String passEn){
        String passDe="";
        char carattere;
        int Ascii;
        for(int i=0;i<passEn.length();i+=3){
            Ascii = Integer.valueOf(passEn.substring(i, i+3)) - 10;
            carattere = (char) Ascii;
            passDe += carattere;
        }
        return passDe;
    }
        
    public void setPass(String passDe){
        passwordDecrypted = passDe;
        passwordEncrypted = this.passwordEncryption(passDe);
    }
    
    public void LogUser(airportFileHandler handler){
        boolean ctr;
        ctr = handler.controlUser(this.toString());
        if (ctr){
            status="Online";
            idUtente = Integer.valueOf(handler.getIdUser((nome+"~"+cognome)));
        }
        else{
            System.out.println("Dati Non Validi");
        }
    }
    
    public String getStatus(){
        return status;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
  
    private boolean charControl(char carattere){
        if(carattere=='~'){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public void setNomeCognome(String name,String surname){
        nome = name;
        cognome = surname;
    }
    
    public void changeNomeCognome(String name,String surname, airportFileHandler handler){
        boolean charError = false;
        for(int i=0; i<name.length(); i++){
            charError= this.charControl(name.charAt(i));
        }
        for(int i=0; i<surname.length(); i++){
            charError= this.charControl(surname.charAt(i));
        }
        if(charError){
            System.out.println("Il Carattere '~' Non E` Ammesso Dal Sistema.");
        }
        else{
            nome = name;
            cognome = surname;
            this.aggiornamentoUtente(handler);
        }
    }
    
    public void changePass(String passDe,airportFileHandler handler){
        boolean charError = false;
        for(int i=0; i<passDe.length(); i++){
            charError= this.charControl(passDe.charAt(i));
        }
        if(charError){
            System.out.println("Il Carattere '~' Non E` Ammesso Dal Sistema.");
        }
        else{
            passwordDecrypted = passDe;
            passwordEncrypted = this.passwordEncryption(passDe);
            this.aggiornamentoUtente(handler);
        }
    }
    
    private void aggiornamentoUtente(airportFileHandler handler){
        handler.aggiornaUtente(this.toString(),String.valueOf(idUtente));
    }
    
    public void userRegistration(airportFileHandler handler){
        System.out.println("PASSENCRYPTED: " + passwordEncrypted);
        idUtente = handler.getLastIdUtente();
        idUtente += 1;
        System.out.println("IdUtente: "+idUtente);
        handler.registraUtente(this.toString());
        System.out.println("Registrazione Effettuata");
    }
    
    
    
    
}
