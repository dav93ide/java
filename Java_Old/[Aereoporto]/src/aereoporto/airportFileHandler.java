
package aereoporto;

import java.io.*;


public class airportFileHandler {
    
    private String addressDir;
    
    public airportFileHandler(String str){
        addressDir=str;
    }
    
    public void setDir(String str){
        addressDir = str;
        this.checkDir();
    }
    
    public boolean checkDir(){
        File dir = new File (addressDir);
        if(dir.exists()){
            System.out.println("Directory Esistente.");
            this.checkFiles();
            return true;
        }
        else{
            System.out.println("Directory Inesistente, Inserire Una Directory Valida");
            return false;
        }
    }
    
    
    public void checkFiles(){
        File dir = new File(addressDir);
        String[] files = dir.list();
        boolean err1= false;
        boolean err2=false;
        for(int i=0; i<files.length;i++){
            if(files[i].equals("IdVoli.txt")){
                err1 = true;              
            }
            if(files[i].equals("DatiVoli.txt")){
                err1 = true;
            }
            if(files[i].equals("IdUtenti.txt")){
                err1 = true; 
            }
            if(files[i].equals("Prenotazioni.txt")){
                err2=true;
            }
        }
        if(err1==false){
            System.out.println("Exception~File.notExists");
            while(Aereoporto.systemError());
        }
        if(err2==false){
            try{
                    File filename = new File(addressDir+"Prenotazioni.txt");
                    filename.createNewFile();
                }
            catch (IOException ex){
                System.out.println("Attenzione! Eccezione In checkFiles");
                ex.printStackTrace();
                while(Aereoporto.systemError());
            }
        }
    }
    
    public void getLineFromIdVoli(String partenza, String destinazione, voli volo){
        try{
            BufferedReader buff = new BufferedReader(new FileReader(addressDir+"IdVoli.txt"));
            String linea = buff.readLine();
            while(linea!=null){
                linea = this.replaceLinea(linea);
                if(linea.contains((partenza+"~"+destinazione))){
                    this.getIdVoli(linea, volo);
                }
                linea = buff.readLine();
            }
            buff.close();
        }
        catch(IOException ex){
            System.out.println("Attenzione!Eccezione In getLineFromIdVoli");
            ex.printStackTrace();
            while(Aereoporto.systemError());
        }
    }
    
    private void getIdVoli(String str, voli volo){
        int nChar=0;
        String idVolo;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='~'){
                nChar+=1;
            }
            if(nChar==2){
                idVolo= str.substring((i+1),(str.length()-1));
                System.out.println("IDVOLO GETIDVOLI="+idVolo);
                getLineDatiVoli(idVolo, volo);
                break;
            }
        }
    }
    
    private void getLineDatiVoli(String idVolo, voli volo){
        try{
            int num=0;
            int i = 0;
            String str="";
            BufferedReader buff = new BufferedReader(new FileReader(addressDir+"DatiVoli.txt"));
            String linea = buff.readLine();
            while(linea!=null){
                linea = this.replaceLinea(linea);
                if(linea.contains(idVolo)){
                    for(; linea.charAt(i)!='~';i++)
                    str = linea.substring((i+2),linea.length());
                    System.out.println("STR IN GETLINEDATIVOLI="+str);
                    this.getDatiVoli(str,num,volo);
                    num+=1;
                }
                linea = buff.readLine();
            }
            buff.close();
        }
        catch(IOException ex){
            System.out.println("Attenzione!Eccezione In getLineDatiVoli");
            ex.printStackTrace();
            while(Aereoporto.systemError());
        }
    }
    
    private void getDatiVoli(String str, int num, voli volo){
        System.out.println("Str IN GETDATIVOLI:"+ str);
        System.out.println("NUM IN GETDATIVOLI:"+ num);
        System.out.println("StrS1 IN GETDATIVOLI:"+ str.substring(0,2));
        System.out.println("StrS2 IN GETDATIVOLI:"+ str.substring(3,6));
        System.out.println("StrS3 IN GETDATIVOLI:"+ str.substring(7,10));
        System.out.println("StrS4 IN GETDATIVOLI:"+ str.substring(11,17));
        System.out.println("StrS5 IN GETDATIVOLI:"+ str.substring(18,34));
        int postiTot,postiLib;
        postiTot=Integer.valueOf(str.substring(3,6));
        postiLib=Integer.valueOf(str.substring(7,10));
        double costo;
        costo=Double.valueOf(str.substring(11,17));
        volo.setClasse(num,str.substring(0,2));
        volo.setPostiTotali(num,postiTot);
        volo.setPostiLiberi(num,postiLib);
        volo.setCosto(num,costo);
        volo.setDataVolo(num,str.substring(18,34));     
        volo.setVetEnd();
    }
        
    public String getIdVoloPrenotation(int idPrenotation){
        String strPrenotation = String.valueOf(idPrenotation);
        String idVolo="";
        while(idVolo.equals("")){
            try{
                BufferedReader buff = new BufferedReader(new FileReader(addressDir+"Prenotazioni.txt"));
                String linea = buff.readLine();
                while(linea!=null){
                    linea = this.replaceLinea(linea);
                    if(linea.contains(strPrenotation)){
                        int nChar=0;
                        for (int i=0; i< linea.length(); i++){
                            if(linea.charAt(i)=='~'){
                                nChar+=1;
                            }
                            if(nChar==3){
                                for(int j=i+1; linea.charAt(j)!='~';j++ ){
                                    idVolo+=linea.charAt(j);
                                }
                                break;
                            }
                        }
                    }
                    linea = buff.readLine();
                }
                buff.close();
            }
            catch(IOException ex){
                System.out.println("Attenzione!Eccezione Nella Ricerca Nome Citta` Di Partenza");
                ex.printStackTrace();
                while(Aereoporto.systemError());
            }
        }
        return idVolo;
    }
    
    public int getLastPrenotation(){
        int lastPrenotation=0;
        while(lastPrenotation==0){
            try{
                BufferedReader buff = new BufferedReader(new FileReader(addressDir+"Prenotazioni.txt"));
                String linea = buff.readLine();
                String Prenotation="";
                int nChar=0;
                while(linea!=null){
                    linea = this.replaceLinea(linea);
                    for (int i=0; i< linea.length(); i++){
                        if(linea.charAt(i)=='~'){
                            nChar+=1;
                        }
                        if(nChar==1){
                            for(int j=i+1; linea.charAt(j)!='~';j++ ){
                                Prenotation+=linea.charAt(j);
                            }
                            nChar=0;
                            break;
                        }
                    }
                    if(lastPrenotation<Integer.valueOf(Prenotation)){
                        lastPrenotation=Integer.valueOf(Prenotation);
                    }
                    linea = buff.readLine();
                }
                buff.close();
            }
            catch(IOException ex){
                System.out.println("Attenzione!Eccezione In getLastPrenotation");
                ex.printStackTrace();
                while(Aereoporto.systemError());
            }
        }
        return lastPrenotation;
    }
    
    public void aggiornaUtente(String str, String idUtente){
        try{
            BufferedReader inputStream = new BufferedReader(new FileReader(addressDir+"IdUtenti.txt"));
            String linea;
            File file1 = new File("IdUtenti1.txt");
            File file2 = new File("IdUtenti.txt");
            file1.createNewFile();
            PrintWriter outputStream = new PrintWriter(new FileWriter(addressDir+"IdUtenti1.txt"));
            linea=inputStream.readLine();
            while(linea!=null){
                linea = this.replaceLinea(linea);
                if(linea.contains(idUtente)){
                    outputStream.println(str);
                    continue;
                }
                outputStream.println(linea);
                linea=inputStream.readLine();
            }
            file2.delete();
            file1.renameTo(file2);
            file1.delete();
            inputStream.close();
            outputStream.close();
        }
        catch(IOException ex){
            System.out.println("Attenzione!Eccezione In aggiornaUtente");
            ex.printStackTrace();
            while(Aereoporto.systemError());
        }
    }
    
    public void setDatiVolo(String str, String idVolo){
        try{
            BufferedReader inputStream = new BufferedReader(new FileReader(addressDir+"IdUtenti.txt"));
            String linea;
            File file1 = new File("DatiVoli.txt");
            File file2 = new File("DatiVoli1.txt");
            file2.createNewFile();
            PrintWriter outputStream = new PrintWriter(new FileWriter(addressDir+"DatiVoli1.txt"));
            linea=inputStream.readLine();
            while(linea!=null){
                linea = this.replaceLinea(linea);
                if(linea.contains(idVolo)){
                    outputStream.println(str);
                    continue;
                }
                outputStream.println(linea);
                linea=inputStream.readLine();
            }
            file1.delete();
            file2.renameTo(file1);
            inputStream.close();
            outputStream.close();
        }
        catch(IOException ex){
            System.out.println("Attenzione!Eccezione In aggiornaUtente");
            ex.printStackTrace();
            while(Aereoporto.systemError());
        }
    }
    
    public boolean controlUser(String str){
        boolean ctr=false;
            try{
                BufferedReader buff = new BufferedReader(new FileReader(addressDir+"IdUtenti.txt"));
                String linea = buff.readLine();
                while(linea!=null){
                    linea = this.replaceLinea(linea);
                    if(linea.equals(str)){
                        ctr=true;
                        break;
                    }
                    linea = buff.readLine();
                }
                buff.close();
            }
            catch(IOException ex){
                System.out.println("Attenzione!Eccezione In controlUser");
                ex.printStackTrace();
                while(Aereoporto.systemError());
            }
        return ctr;
    }
    
    public String getIdUser(String nomeCognome){
        String idUser="";
            try{
                BufferedReader buff = new BufferedReader(new FileReader(addressDir+"IdUtenti.txt"));
                String linea = buff.readLine();
                while(linea!=null){
                    linea = this.replaceLinea(linea);
                    if(linea.contains(nomeCognome)){
                        for(int i=0; linea.charAt(i)!='~';i++){
                            idUser+=linea.charAt(i);
                        }
                    }
                    linea = buff.readLine();
                }
                buff.close();
            }
            catch(IOException ex){
                System.out.println("Attenzione!Eccezione In getIdUser");
                ex.printStackTrace();
                while(Aereoporto.systemError());
            }
        return idUser;
    }
    
    public int getLastIdUtente(){
        int lastIdUtente=0;
        String idUtente="";
            try{
                BufferedReader buff = new BufferedReader(new FileReader((addressDir+"IdUtenti.txt")));
                String linea=buff.readLine();
                System.out.println("VALORE DI LINEA IN GETLASTIDUTENTE="+linea);
                if(linea==null){
                    lastIdUtente=1;
                }
                else{
                    while(linea!=null){
                        for (int i=0; linea.charAt(i)!='~'; i++){
                            idUtente+=linea.charAt(i);
                        }
                        if((!idUtente.equals("")) && lastIdUtente<Integer.valueOf(idUtente)){
                            lastIdUtente=Integer.valueOf(idUtente);
                        }
                        idUtente="";
                        linea = buff.readLine();
                    }
                    buff.close();
                }
            }
            catch(IOException ex){
                System.out.println("Attenzione!Eccezione In getLastIdUtente");
                ex.printStackTrace();
                while(Aereoporto.systemError());
            }
        System.out.println("LASTIDUTENTE FINALE=" + lastIdUtente);
        return lastIdUtente;
    }
    
    public String replaceLinea(String linea){
        String linea2;
        int val;
        val=(int) linea.charAt(0);
        if(val==65279){
            linea2= linea.substring(1, linea.length());
        }
        else {
            linea2=linea;
        }
        return linea2;
    }
    
    public void registraUtente(String str){
        try{
            String line;
            FileWriter file = new FileWriter(addressDir+"IdUtenti.txt");
            FileReader file2 = new FileReader(addressDir+"IdUtenti.txt");
            BufferedWriter outputStream = new BufferedWriter(file);
            BufferedReader read = new BufferedReader(file2);
            line=read.readLine();
            if(line==null){
                outputStream.write(str);
            }
            else{
                while(line!=null){
                    line=read.readLine();
                }
                outputStream.write(str);
            }
            outputStream.close();
        }
        catch(IOException ex){
            System.out.println("Attenzione!Eccezione In aggiornaUtente");
            ex.printStackTrace();
            while(Aereoporto.systemError());
        }
    }
}