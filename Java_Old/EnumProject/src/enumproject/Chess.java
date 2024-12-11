package enumproject;

public enum Chess {
    PEDONE(8),
    ALFIERE,
    CAVALLO,
    TORRE,
    REGINA(1),
    RE(1);
    
    private int nPezzi;
    
    private Chess(int nPezzi){
        this.nPezzi = nPezzi;
    }
    
    private Chess(){
        this.nPezzi = 2;
    }
    
    public int getNPezzo(){
        return this.nPezzi;
    }
    
    public int getNTotPezzi(){
        int totPezzi = 0;
        for(Chess obChess : Chess.values()){
            totPezzi += obChess.getNPezzo();
        }
        return totPezzi;
    }
    
}
