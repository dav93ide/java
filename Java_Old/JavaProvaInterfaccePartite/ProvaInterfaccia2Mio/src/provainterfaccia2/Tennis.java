package provainterfaccia2;

public class Tennis extends Sport implements IPartite{
    
    public Tennis(int iLen){
        ris1 = new int[iLen];
        ris2 = new int[iLen];
    }
    
    private int[] ris1;
    private int[] ris2;
    private int tempo = 0;
    
    public int getTime(){
        return ris1.length;
    }
       
    @Override
    public boolean setRisultato(int iR1, int iR2){
        if(tempo<ris1.length & super.getFinal1()!=(ris1.length/2+1) & super.getFinal2()!=(ris2.length/2+1)){ 
            ris1[tempo] = iR1;
            ris2[tempo] = iR2;
            tempo += 1;
            return true;}
        else
            return false;
    }
    
    @Override
    public void setSquadre(String s1, String s2){
        this.nome1 = s1;
        this.nome2 = s2;
    }
    
    @Override
    public void getRisultati(){
        System.out.println("|Sport: "+ this.getClass().getSimpleName());
        for(int i=0; i<ris1.length;i++){
            System.out.println("|Tempo: "+ (i+1) + 
                    "|\n\t | Squadre: " + this.nome1 + " / " + this.nome2 +
                    " | Risultato: " + this.ris1 + " / " + this.ris2);
        }
    }
    
    
}
