/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometria;

/**
 *
 * @author biagiorosariogreco
 */
public class retta {
    private double m, q;
    
    public retta(){
        m = 0.;
        q = 0.;
    }
    
    public retta(double m, double q) {
        this.m = m;
        this.q = q;
    }
    
    public retta(retta r) {
        this.m = r.m;
        this.q = r.q;
    }
    
    @Override
    public String toString(){
        return ("y = " + m + "x + " + q);
    }
    
    public double get_m() {
        return m;
    }

    public double get_q() {
        return q;
    }
    
    public boolean isParallel(retta r) {
        return m == r.m;
    }
}
