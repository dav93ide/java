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
public class Punto {
    protected double x, y;
    
    public Punto(double x , double y) {
        this.x = x;
        this.y = y;
    }
    
    public Punto() {
        this(0., 0.);
    }
    
    public Punto(double xy) {
        this(xy, xy);
    }
    
    public Punto(Punto P) {
        this(P.x, P.y);
    }
    
    public double dist(Punto P) {
        return Math.sqrt((x - P.x) * (x - P.x) + (y - P.y) * (y - P.y));
    }
    
    public double get_x() {
        return x;
    }

    public double get_y() {
        return y;
    }
    
    @Override
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }
    
    public void set_x(double x) {
        this.x = x;
    }
    public void set_y(double y) {
        this.y = y;
    }
}
