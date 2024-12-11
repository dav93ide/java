package giroitalia;

    public enum Classifica{
        primo,
        secondo,
        terzo;
        
        private String nome;
        
        private Classifica(){
        }
        
        public void setNome(String sName){
            this.nome = sName;
        }
 
        @Override
        public String toString(){
            String sReturn = "";
            for(Classifica cl : Classifica.values()){
                sReturn += cl.name() + " Classificato, Nome: " + cl.nome;
            }
            return sReturn;
        }
    }
