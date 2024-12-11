/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contocorrente;



    public class Main {
        public static void main(String[] args){
            ContoCorrente cc = new ContoCorrente(1000); /*Creo un oggetto "cc" dalla classe "ContoCorrente"*/
            cc.Saldo();
            System.out.print("\n Inserire Importo Da Prelevare \n");
            cc.prelievo(cc.input.nextDouble());
            System.out.print("\n Inserire Importo Da Versare \n");
            cc.versamento(cc.input.nextDouble());
            cc.Interesse(10);
        }
        
    } 
