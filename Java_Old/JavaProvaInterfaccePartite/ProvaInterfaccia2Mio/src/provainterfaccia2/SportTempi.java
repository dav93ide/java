package provainterfaccia2;

public class SportTempi extends Sport implements IPartite {
    
    private int[] ris1;
    private int[] ris2;
    private int tempo = 0;
    
    public SportTempi(int iLen){
        ris1 = new int[iLen];
        ris2 = new int[iLen];
    }
        
    @Override
    public boolean setRisultato(int iR1, int iR2){
        if(tempo<ris1.length){ 
            ris1[tempo] = iR1;
            ris2[tempo] = iR2;
            tempo += 1;
            if(tempo==ris1.length-1) this.setFinalRis();
            return true;}
        else
            return false;
    }
    
    @Override
    public void setSquadre(String s1, String s2){
        this.nome1 = s1;
        this.nome2 = s2;
    }
    
    public void setFinalRis(){
        for(int i=0; i<ris1.length;i++){
            super.setFinalRis(ris1[i],ris2[i]);
        }
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
