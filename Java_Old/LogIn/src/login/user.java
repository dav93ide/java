package login;

public class user {
    private String userName;
    private String passDe;
    private int userID;
    private String userFile;
    private String userStatus;
    
    public user(){
        userName="Guest";
        userStatus="Guest";
        passDe="Guest";
        userID = 0;
        userFile = "NoFile";
    }
    
    @Override
    public String toString(){
        return new String("UserName: "+ userName + " Password: "+ passDe + " userStatus: "+ userStatus + " userID: " + userID + " userFile: "+ userFile);
    }
    
    public String getUserFile(){
        return userFile;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getUserStatus(){
        return userStatus;
    }
    
    public void readFile(String fileName,fileHandler handler){
        if(!userFile.equals("NoFile")){
            handler.readUserFile(userFile);
        }
        else{
            System.out.println("Nessun File Per Questo Utente");
        }
    }
    
    public boolean changeUser(String userNome, String passwordDe, fileHandler handler){
        String nome,pass,search;
        search = this.searchUser(userNome,handler);
        if(!search.equals("stringNotFound")){
            nome = handler.searchUserInfoInLine(search,"userName");
        }
        else{
            System.out.println("Nome Utente Non Trovato");
            return false;
        }
        pass = this.passwordEncryption(passwordDe);
        if(pass.equals(handler.searchUserInfoInLine(search,"userPass"))){
            System.out.println("Nome Utente E Password Corretti, LogIn.");
            userName = userNome;
            passDe = passwordDe;
            userID = Integer.valueOf(handler.searchUserInfoInLine(search,"userID"));
            userFile = (handler.searchUserInfoInLine(search,"userFileName").equals("0"))?"NoFile" : handler.searchUserInfoInLine(search,"userFileName");
            userStatus=(userID==0 & userName.equals("Admin"))?"AdminOnline":"userOnline";
            return true;
        }
        else{
            System.out.println("Password Non Corretta");
            return false;
        }
    }
    
    public String searchUser(String userNome, fileHandler handler){
        String search;
        search = handler.searchInfoInFile(userNome,handler.getFileInfoNome());
        if(search.equals("stringNotFound")){
            return "stringNotFound";
        }
        else{
            if(!userNome.equals(handler.searchUserInfoInLine(search,"userName"))){
                return "stringNotFound";
            }
            else{
                return search;
            }
        }
    }
    
    public boolean registraUser(String userNome, String passwordDe, fileHandler handler){
        if(this.searchUser(userNome,handler).equals("stringNotFound")){
            if(handler.writeInFile(handler.getFileInfoNome(), new String("~"+userNome+"~"+this.passwordEncryption(passwordDe)+"~"
                    + (handler.getLastID()+1) + "~" + "NoFile" + (handler.getLastID()+1) + "~") ,true)){
                System.out.println("Utente Registrato");
                return true;
            }
            else{
                System.out.println("Errore Nella Registrazione Del Nuovo Utente.");
                return false;
            }
        }
        else{
            System.out.println("Creazione Utente Impossibile, Nome Gia` Esistente");
            return false;
        }
    }
    
    public boolean createFileUtente(String fileName, fileHandler handler){
        fileName=handler.checkFileName(fileName);
        if(handler.checkFile(fileName)){
                System.out.println("File Gia` Esistente, Scegliere Un Altro Nome");
                return false;
        }
        else{
            if(handler.createFileTxt(fileName)){
                System.out.println("File " + fileName+ " Creato.");
                if(handler.replaceInFile(userFile+userID, fileName,handler.getFileInfoNome(),true)){
                    System.out.println("Nuovo File Utente "+ fileName + " Creato Con Successo");
                    userFile = fileName;
                    return true;
                }
                else{
                    System.out.println("Nuovo File Utente Non Creato, Modifica Linea Utente Non Eseguita");
                    return false;
                }
            }
            else{
                System.out.println("Nuovo File Utente Non Creato, Creazione File Non Eseguita");
                return false;
            }
        }
    }
    
    private String passwordEncryption(String passDecrypted){
        String passEncrypted="";
        String strTemp;
        int Ascii;
        for(int i=0; i < passDecrypted.length(); i++){
            Ascii = ((int)passDecrypted.charAt(i))+23;
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
            passEncrypted+=strTemp;
        }
        return passEncrypted;
    }
    
    public boolean changePass(String newPass, String userName, fileHandler handler){
        if(handler.replaceInFile(this.passwordEncryption(passDe), this.passwordEncryption(newPass), handler.getFileInfoNome(), true)){
            System.out.println("Password Sostituita");
            passDe = newPass;
            return true;
        }
        else{
            System.out.println("Password Non Sostituita");
            return false;
        }
    }
    
    private String passwordDecryption(String passEncrypted){
        String passDecrypted="";
        char carattere;
        int Ascii;
        for(int i=0;i<passEncrypted.length();i+=3){
            Ascii = Integer.valueOf(passEncrypted.substring(i,i+3))-23;
            carattere = (char) Ascii;
            passDecrypted += carattere;
        }
        return passDecrypted;
    }
    
    public String getPassDe(String passEncrypted){
        return this.passwordDecryption(passEncrypted);
    }
    
    public String getPassEn(String passDecrypted){
        return this.passwordEncryption(passDecrypted);
    }    
}
