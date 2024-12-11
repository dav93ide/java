
package pianocartesiano;
import java.util.Scanner;

public class Punti {
    protected double corX;
    protected double corY;
    Scanner input = new Scanner(System.in);

    
    
    public Punti(){
        corX=0.0;
        corY=0.0;
    }
    public Punti(double x, double y){
        corX=x;
        corY=y;
    }
    public void info(){
        System.out.println("\nCoordinate punto 1 x: "+ corX + " Coordinate y: "+ corY);
    }
    public double corX(){
        return corX;
    }
    public double corY(){
        return corY;
    }
    public void changeCor(){
           System.out.println("\nInserire Coordinate x");
            corX = input.nextDouble();
           System.out.println("\nInserire Coordinate y");
            corY= input.nextDouble();
    }
}