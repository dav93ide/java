package provathread3;

public class ThreadSistema extends Thread {
    private Matrice objectMatrix;
    private String name;
    private long numCommutazioni;
    private boolean completed;
    
    public ThreadSistema (Matrice oM,String sName){
        this.name=sName;
        this.objectMatrix = oM;
        this.numCommutazioni = 0;
        this.completed = false;
    }
    
    public void getStampMatrix(){
        this.objectMatrix.visualPresentation();;
    }
    
    public void riordina(){
        int nMin=10001;
        int posI=0,posJ=0;
        int i=this.objectMatrix.getLastPosX();
        int j=this.objectMatrix.getLastPosY(); 
        for(;i<this.objectMatrix.getMaxPosX();i++){
            if(i!=this.objectMatrix.getLastPosX()){
                j=0;
            }
            for(;j<this.objectMatrix.getMaxPosY();j++){
                if(nMin>this.objectMatrix.getNum(i,j)){
                    nMin = this.objectMatrix.getNum(i,j);
                    posI=i;
                    posJ=j;
                }
            }
        }
        if(this.objectMatrix.getLastPosX()== (this.objectMatrix.getMaxPosX()-1) & this.objectMatrix.getLastPosY() == (this.objectMatrix.getMaxPosY()-1)){
            System.out.println("\n\n\n/////////////////////////////RIORDINATA DA:"+this.name+"////////////////////////////////////////\n\n\n");
            completed = true;
        }
        else{
            int val2=this.objectMatrix.getNum(this.objectMatrix.getLastPosX(),this.objectMatrix.getLastPosY());
            //System.out.println(this.name+" -- Numero Da Sostituire: "+ val2 + " Numero sostituto: "+ nMin);
            this.objectMatrix.setNum(this.objectMatrix.getLastPosX(),this.objectMatrix.getLastPosY(), nMin);
            this.objectMatrix.setNum(posI, posJ, val2);
            if(this.objectMatrix.getLastPosY()== this.objectMatrix.getMaxPosY()-1){
                this.objectMatrix.resetPosY();
                this.objectMatrix.AddLastPosX();
            }
            else{
                this.objectMatrix.AddLastPosY();
            }
            this.numCommutazioni+=1;
        }
    }
    
    public long getNCommutazioni(){
        return this.numCommutazioni;
    }
    
    @Override
    public void run(){
        while(!completed){
            this.riordina();
        }
        this.interrupt();
    }
}
