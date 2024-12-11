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
public class Cerchio extends Punto {

    double r;
	
    public Cerchio(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }
	
    public Cerchio() {
        this(0.);
    }
	
    public Cerchio(double r){
        this(0., 0., r);
    }
    
    public Cerchio(Punto P, double r){
        //this(P.x, P.y, r);
		this(r);
        super(P);
    }
	
    public Cerchio(Cerchio C){
        this(C.x, C.y, C.r);
    }
    
    public void set_r(double r) {
        this.r = r;
    }
    
    public double get_r() {
        return r;
    }
    
    public Punto get_center(){
        return new Punto(this.x, this.y);
    }

}
