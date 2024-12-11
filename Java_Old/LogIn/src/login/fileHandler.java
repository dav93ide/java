package login;
import java.io.*;
import java.nio.file.Files;

public class fileHandler {
    private String addressDir;
    private String fileInfoNome;
    
    public fileHandler(String directory, String fileName){
        addressDir = directory;
        fileInfoNome = fileName;
    }
    
    public String getFileInfoNome(){
        return fileInfoNome;
    }
    
    public String getAddressDir(){
        return addressDir;
    }
    
    public void fileList(){
        File dir = new File(addressDir);
        for(int i=0; i<dir.list().length;i++){
            System.out.print((i+1)+"] "+dir.list()[i]+"\n");
        }
    }
    
    private boolean checkDir(String dir){
        File directory = new File(dir);
        if(directory.exists()){
            return true;
        }
        else{
            System.out.println("Directory Inesistente");
            return false;
        }
    }
    
    public boolean setDir(String dir){
        if(this.checkDir(dir)){
            addressDir=dir;
            return true;
        }
        else{
            System.out.println("Directory Non Settata");
            return false;
        }
    }
    
    public boolean setFileInfoNome(String nomeFile){
        nomeFile=this.checkFileName(nomeFile);
        if(this.checkFile(nomeFile)){
            fileInfoNome=nomeFile;
            return true;
        }
        else{
            System.out.println("File Non Settato");
            return false;
        }
    }
    
    public boolean checkFile(String fileName){
        File nomeFile = new File(addressDir+fileName);
        if(nomeFile.exists()){
            return true;
        }
        else{
            System.out.println("File Inesistente");
            return false;
        }
    }
    
    public String checkFileName(String fileName){
        if(!fileName.endsWith(".txt")){
            if(fileName.contains(".")){
                String tempStr="";
                for(int i=0; fileName.charAt(i)=='.';i++){
                    tempStr+=fileName.charAt(i);
                }
                fileName=tempStr;
            }
            fileName+=".txt";
        }
        return fileName;
    }
    
    public boolean createFileTxt(String fileName){
        try{
            fileName=this.checkFileName(fileName);
            File nomeFile = new File(addressDir+fileName);
            nomeFile.createNewFile();
            return true;
        }
        catch(IOException ex){
            System.out.println("Eccezione In fileHandler.createFile");
            ex.getStackTrace();
            return false;
        }
    }
    
    public String searchInfoInFile(String searchedStr,String fileName){
        if(this.checkFile(fileName)){
            try{
                String linea;
                BufferedReader read = new BufferedReader(new FileReader(addressDir+fileName));
                linea=read.readLine();
                while(linea!=null){
                    if(linea.contains(searchedStr)){
                        read.close();
                        return linea;
                    }
                    linea=read.readLine();
                }
                read.close();
            }
            catch(IOException ex){
                System.out.println("Eccezione In fileHandler.searchInFile");
                ex.getStackTrace();
            }
        }
        System.out.println("Nessun Risultato");
        return "stringNotFound";
    }
    
    public int getLastID(){
        try{
            String linea;
            int ID1;
            ID1=0;
            BufferedReader read = new BufferedReader(new FileReader(addressDir+fileInfoNome));
            while((linea=read.readLine())!=null){
                if(ID1<Integer.valueOf(this.searchUserInfoInLine(linea,"userID"))){
                    ID1=Integer.valueOf(this.searchUserInfoInLine(linea,"userID"));
                }
            }
            return ID1;
        }
        catch(IOException ex){
            System.out.println("Eccezione In fileHandler.getLastID");
            ex.getStackTrace();
        }
        return 0;
    }
    
    public String searchUserInfoInLine(String linea,String searchedPart){
        int numSeparatori =0;
        int count = 0;
        String searchedStr="";
        switch(searchedPart){
            case "userName":
                numSeparatori=1;
            break;
            case "userPass":
                numSeparatori=2;
            break;
            case "userID":
                numSeparatori=3;
            break;
            case "userFileName":
                numSeparatori=4;
            break;
            default:
                System.out.println("Eccezione In Switch() di fileHandler.SearchInfoLine");
            break;
        }
        for(int i=0; count<(numSeparatori+1); i++){
            if(linea.charAt(i)=='~'){
                count+=1;
            }
            else{
                if(count==numSeparatori){
                    searchedStr+=linea.charAt(i);
                }
            }
        }
        return searchedStr;            
    }
    
    public boolean deleteFile(String fileName){
        fileName = this.checkFileName(fileName);
        if(this.checkFile(fileName)){
            File file = new File(fileName);
            file.delete();
            System.out.println("File Eliminato Con Successo");
            return true;
        }
        else{
            System.out.println("Impossibile Eliminare Il File");
            return false;
        }
    }
    
    public boolean writeInFile(String fileName, String writeThis, boolean newLine){
        if(this.checkFile(fileName)){
            try{
                FileWriter file = new FileWriter(addressDir+fileName,true);
                if(newLine){
                    file.write(writeThis);
                }
                else{
                    String writeThis2;
                    writeThis2= " " + writeThis;
                    file.append(writeThis2);
                }
                System.out.println("Scrittura Su File Eseguita Con Successo");
                file.close();
                return true;
            }
            catch(IOException ex){
                System.out.println("Eccezione In fileHandler.writeInFile");
                ex.getStackTrace();
                return false;
            }
        }
        else{
            System.out.println("Scrittura Impossibile");
            return false;
        }
    }
    
    public boolean replaceInFile(String searchThis,String writeThis,String fileName, boolean Parola){
        if(this.checkFile(fileName)){
            try{
                String readLine,newFileName;
                newFileName = fileName.substring(0,(fileName.length()-3)) + "1.txt";
                if(!this.createFileTxt(newFileName)){
                    System.out.println("Errore In Creazione newFile Per Sovrascrizione");
                    return false;
                }
                FileWriter write =new FileWriter(addressDir+newFileName);
                BufferedReader read = new BufferedReader(new FileReader(addressDir+fileName));
                readLine = read.readLine();
                while(readLine!=null){
                    if(readLine.contains(searchThis)){
                        if(Parola){
                           String newWriteThis;
                           newWriteThis=readLine.replace(searchThis, writeThis);
                           write.write(newWriteThis);
                        }
                        else{
                           write.write(writeThis);
                        }
                    }
                    else{
                        write.write(readLine);
                    }
                    readLine=read.readLine();
                }
                write.close();
                read.close();
                File file1 = new File(addressDir+fileName);
                File file2 = new File(addressDir+newFileName);
                file1.delete();
                file2.renameTo(file1);
                File file3 = new File(addressDir+newFileName);
                file3.delete();
                System.out.println("Sovrascrittura Eseguita");
                return true;
            }
            catch(IOException ex){
                System.out.println("Eccezione In fileHandler.replaceInFile");
                ex.getStackTrace();
            }
        }
        System.out.println("Sovrascrittura Impossibile");
        return false; 
    }
    
    public boolean readUserFile(String fileName){
        if(this.checkFile(fileName)){
            try{
                String linea;
                int cnt=1;
                BufferedReader read = new BufferedReader(new FileReader(addressDir+fileName));
                while((linea=read.readLine())!=null){
                    System.out.println(cnt+"]"+linea+"\n");
                    cnt+=1;
                }
                System.out.println("~~FINE FILE~~");
                return true;
            }
            catch(IOException ex){
                System.out.println("Eccezione fileHandler.readUserFile");
                ex.getStackTrace();
                return false;
            }
        }
        else{
            System.out.println("Lettura File Impossibile");
            return false;
        }
    }
}
