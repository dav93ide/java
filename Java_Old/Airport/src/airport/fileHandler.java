package airport;
import java.io.*;
public class fileHandler{
    private String addressDir;
    
    public fileHandler(String dir){
        addressDir= dir;
    }
    
    public boolean checkDir(String dir){
        File directory = new File(addressDir);
        if(directory.exists()){
            System.out.println("Directory Esistente");
            return true;
        }
        else{
            System.out.println("Directory Inesistente");
            return false;
        }
    }
    
    public String checkFileName(String fileName){
        if(fileName.endsWith(".txt")){
        }
        else{
            if(fileName.contains(".")){
                String strTemp="";
                for(int i=0;i<fileName.length();i++){
                    if(fileName.charAt(i)=='.'){
                        fileName+=".txt";
                        break;
                    }
                    else{
                        strTemp+=fileName.charAt(i);
                    }
                }
            }
            else{
                fileName+=".txt";
            }
        }
        return fileName;
    }
    
    public boolean checkFile(String fileName){
        fileName=this.checkFileName(fileName);
        File nomeFile = new File(addressDir+fileName);
        return new Boolean((nomeFile.exists())?true:false);
    }
    
    public boolean createFileTxt(String fileName){
        fileName=this.checkFileName(fileName);
        try{
            if(!this.checkFile(fileName)){
                File fileNome = new File(addressDir+fileName);
                fileNome.createNewFile();
                return true;
            }
            else{
                System.out.print("File "+fileName+" Already Exist");
            }
        }
        catch(IOException ex){
            System.out.print("Eccezione in fileHandler.createFileTxt");
            ex.getStackTrace();
        }
        return false;
    }
    
    public String searchInFile(String searchedStr,String fileName){
        fileName = this.checkFileName(fileName);
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
    
    public String searchInLine(String searchLine, String fileName, String identifier){
        fileName = this.checkFileName(fileName);
        if(this.checkFile(fileName)){
            switch(identifier){
                case "userName":
                break;
                case "userPass":
                break;
                case "userID":
                break;
                case "idVolo":
                break;
                case "idPrenotation":
                break;
                default:
                    System.out.print("Eccezione Switch() fileHandler.searchInLine");
                break;
            }
        }
    }
}
