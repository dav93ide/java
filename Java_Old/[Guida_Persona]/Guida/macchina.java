package Guida;
import java.lang.Math;

public class macchina{

	double posizione;
	int marcia;
	
	public macchina(double startPosizione,int startMarcia){
		this.posizione = startPosizione;
		this.marcia = startMarcia;
	}
	
	public macchina(double startPosizione){
		this(startPosizione,0);
	}
	
	public macchina(int startMarcia){
		this(0.,startMarcia);
	}
	
	public macchina(){
		this(0.,0);
	}
	
	public double getPosizione(){
		return posizione;
	}
	
	public void setPosizione(double valore){
		this.posizione=valore;
	}
	
	public void vaiADx(double spostamento){
		this.posizione+=(double)(spostamento*marcia);
	}
	
	public void vaiASx(double spostamento){
		this.posizione-=(double)(spostamento*marcia);
	}
	
	public void marciaPlus(){
		if(marcia<6)
			this.marcia+=1;
		
	}
	
	public void marciaMinus(){
		if(marcia>-1)
			this.marcia-=1;	
	}
	
	public int getMarcia(){
		return marcia;
	}
	
	public String toString(){
		return String("Marcia: "+((marcia<0) ? "R" : marcia)+"\n Posizione: "+ (posizione>0) ? " Destra " : " Sinistra " + Math.abs(posizione);
	}
	
	
}