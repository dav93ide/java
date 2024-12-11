
package gioco_personaggio;

import java.lang.Math;

public class Pg {
        private int cor_x=0;
        private int cor_y=0;
        private boolean versodx;
        private boolean versosx;
        private String name;
            
        public void Avanti(){
                Gira();
                PosMax();
                cor_x++;
        }
        public void Indietro(){
            Gira();
            PosMax();
            cor_x--;
        }
        public void Su(){   
            PosMax();
            cor_y++;
        }
        public void Giu(){
            PosMax();
            cor_y--;
        }
        public void Avanti2(int val){
            Gira();
            PosMax();
            cor_x+=val;               
        }
        public void Indietro2(int val){
            Gira();
            PosMax();
            cor_x+=val;               
        }
        public void Su2(int val){
            PosMax();
            cor_x+=val;               
        }
        public void Giu2(int val){
            PosMax();
            cor_x+=val;               
        }
        public void Scatto(){
            PosMax();
            cor_x*=2;
            cor_y*=2;
        }
        public void Gira(){
            if(versodx){
                versodx=false;
                versosx=true;
            }
            else{
                versosx=false;
                versodx=true;
            }   
        }
        public void PosMax(){               //Raggiungo x+-10 o y+-10 riparte da 0.
            if((cor_x>=10)||(cor_x<=-10)){
                System.out.println("\nEccomi Qui!\n" + Mostra());
                if(cor_x>=10){
                    cor_x= Math.abs(cor_x%10);
                }
                else{
                    if(cor_x<=-10){
                        cor_x= Math.abs(cor_x%10);
                    }}
            }
            if((cor_y==10)||(cor_y==-10)){
                System.out.println("\nEccomi Qui!" + Mostra());
                if(cor_y>=10){
                    cor_y= Math.abs(cor_y%10);
                }
                else{
                    if(cor_y<=-10){
                    cor_y= Math.abs(cor_y%10);
                }} 
            }
            System.out.println("\nValori Risettati!" + Mostra());
        }
        public String Mostra(){
            String out = ("\nValore x:  "+ cor_x +"\tValore y:  "+ cor_y +"\n");
            return out;
        }
        public void Presentazione(){
            System.out.println("\nLasciate che mi presenti, mi chiamo: "+ name
                + "e sono appena stato generato in posizione " + Mostra());
        }
        
                        
        public Pg(){
              
        }
        public Pg(int x, int y, String inputS){
            cor_x+=x;
            cor_y+=y;
            versodx=true;
            versosx=false;
            name = inputS;
        }
}
