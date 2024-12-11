package provathread3;
import java.util.Random;

public class Matrice {
    private int[][] numeri;
    Random rand = new Random();
    private int lastPosX;
    private int lastPosY;
    private int maxX;
    private int maxY;
    
    public Matrice(int maxX, int maxY){
        this.lastPosX=0;
        this.lastPosY=0;
        this.maxX = maxX;
        this.maxY = maxY;
        numeri = new int[maxX][maxY];
        for(int i=0; i<this.maxX;i++){
            for(int j=0;j<this.maxY;j++){
                numeri[i][j] = rand.nextInt(10000)+1;
            }
        }
    }
    
    public int getNum(int x, int y){
        return this.numeri[x][y];
    }
    
    public void setNum(int x, int y,int val){
        this.numeri[x][y] = val;
    }
    
    public int getLastPosX(){
        return this.lastPosX;
    }
    
    public int getLastPosY(){
        return this.lastPosY;
    }
    
    public int getMaxPosX(){
        return this.maxX;
    }
    
    public int getMaxPosY(){
        return this.maxY;
    }
    
    public void AddLastPosX(){
        if(this.lastPosX<=this.maxX){
            this.lastPosX++;
        }
        else{
            System.out.println("LastPosX Out Of Range");
        }
    }
    
    public void AddLastPosY(){
        if(this.lastPosY<=this.maxY){
            this.lastPosY++;
        }
        else{
            System.out.println("LastPosY Out Of Range");
        }
    }
    
    public void visualPresentation(){
        for(int i=0; i<this.maxX;i++){
            for(int j=0; j<this.maxY; j++){
                System.out.print("|"+this.numeri[i][j]+"|");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n ---------------------------------------------------------------------------------------- \n\n");
    }
    
    public void resetPosY(){
        this.lastPosY = 0;
    }
}
