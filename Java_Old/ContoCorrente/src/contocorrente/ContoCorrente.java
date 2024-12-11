/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contocorrente;

import java.util.Locale;

/**
 *
 * @author davidesavian
 */
public class ContoCorrente {
    private double saldo;
    public double max_saldo=20000;
    public double max_versamento=5000;
    public double max_prelievo=2000;
    java.util.Scanner input = new java.util.Scanner(System.in);                    /*Creo un oggetto "input" costruendo un tipo "java.util.Scanner"
                                                                                     che agisce sul "System.in" per analizzare l'inserimento da console.*/
    
    public double get_saldo(){
        return saldo; 
    }
    
    
    
    private void Stampa_Nuovo_Saldo(double money, String operazione){
        System.out.println("Importo " + operazione +" Tuo Conto:\t " + money);
        Saldo();
    }
    
    public void Saldo(){
        System.out.println("Saldo Attuale:\t" + saldo);
    }
    public void versamento(double money){
        if((saldo+money)>max_saldo){ 
            Gestione_Errori("Except_01", money);
        }
        else{
            if(money>max_versamento){
                Gestione_Errori("Except_02", money);
            }
            else{
                saldo += money;
                System.out.println("Versamento Avvenuto Con Successo");
                Stampa_Nuovo_Saldo(money, "Versato Sul");
            }
        }
    }
    
    public void prelievo(double money){
        if(saldo<money){
            Gestione_Errori("Except_03", money);
        }
        else{
            if (money>max_prelievo){
                Gestione_Errori("Except_04", money);
            }
            else{
            saldo -= money;
            System.out.println("Prelievo Avvenuto Con Successo");
            Stampa_Nuovo_Saldo(money, "Prelevato Dal");
            }
        }
    }
    
    public ContoCorrente(double money){     //Costruttore per costruire i vari oggetti prima dichiarati
        saldo = money;                      /*Il Costruttore Inizializza Il Saldo Con Il Parametro Passato
                                                Al Nuovo Tipo "ContoCorrente" Nel Main. */ 
        System.out.println("\n\n**Costruttore Ad Un Parametro**\n\n");
    }
    
    public ContoCorrente(){
        saldo=0.;
        System.out.println("\n\n**Costruttore A 0 Parametri**\n\n");
    }
    
    public void Interesse(double interesse){
        System.out.println("Congratulazioni Il Tuo Saldo Ha Maturato Un Interesse Netto Del: " + interesse + "%");
        double val_interesse = saldo * interesse / 100;
        saldo += val_interesse;
        Stampa_Nuovo_Saldo(val_interesse, "Di Interessi Versato Sul");
    }
    public void Gestione_Errori(String Error, double money){
        switch(Error){
            case "Except_01": System.out.println("\nSoglia Saldo Massima Superata, Versamento Non Effettuato.");
                                System.out.println("Totale Euro In Eccesso Su Soglia Massima Saldo: " + ((saldo+money)-max_saldo) + "\n");
            break;
            case "Except_02": System.out.println("\nSoglia Versamento Massima Superata, Versamento Non Effettuato.");
                                System.out.println("Totale Euro In Eccesso Su Soglia Massima Versamento: " + (money - max_versamento) + "\n");
            break;
            case "Except_03": System.out.println("\nSaldo Insufficiente, Prelievo Non Effettuato.");
                                System.out.println("Totale Euro Mancanti Su Saldo Attuale: " + (money - saldo) + "\n");
            break;
            case "Except_04": System.out.println("\nSoglia Massima Di Prelievo Superata, Prelievo Non Effettuato.");
                                System.out.println("Totale Euro In Eccesso Su Soglia Massima Prelievo: " + (money-max_saldo) + "\n");
            break;
            default: System.out.println("Error: Unespected Exception.");
            break;
        }
    }
    
}