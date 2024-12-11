/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianocartesiano;

/**
 *
 * @author davidesavian
 */
public class Retta extends Punti{
    protected double valQ;
    
    public Retta(){
        corX=0.0;
        corY=0.0;
        valQ=0.0;
    }
    public Retta(double x, double y, double q){
        this.corX=x;
        this.corY=y;
        valQ=q;
    }
    public void infoEsp(){
        System.out.println("\nForma Esplicita Retta -> y = "+ corX + "x + " + valQ);
        }
    public void infoImp(){
        System.out.println("\nForma Implicita Retta ->"+corX+"x +"+corY+"y + " + valQ);
    }
    public double coefM(){
        double coef;
        coef = - (corX/corY);
        return coef;
    }
    public double retQ(){
    return valQ;
    }
}
    
