/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dipendenti;

import java.util.Scanner;

public class Employee {
    String[] nome = new String[50];
    String[] cognome = new String [50];
    private double[] stipendio = new double[50];
    private static Scanner input = new Scanner(System.in);  // Creo Oggetto Scanner Per Salvare Input Utente
    
    public int intPut(){    //Creo Metodi Pubblici Per Utilizzare In Main Funzioni Di "input"
        int num;
        num = input.nextInt();
        return num;
    }
    
    public static String stringPut(){   //Statica per Acquisire Valori Prima Di Creazione Oggetto "lavoratori"       
        String str;
        str = input.nextLine();
        return str;
    }
    
    public double doublePut(){
        double num;
        num = input.nextDouble();
        return num;
    }
    
    public Employee(){
        nome[0]="";
        cognome[0]="";
        stipendio[0]= 0.0;
    }
    public Employee(String name, String surname, double salario){
            nome[0] = name;
            cognome[0] = surname;
            stipendio[0] = salario;
            cognome[1]="fine";  //Creo Stringa Di Tappo In Vettore
    }
    public void infoDipendenti(int i, int n, int scelta){
        int max = trovaCognome("fine");
        if(scelta==1){
            if ((n-1)>=max){
                System.out.println("\nID Dipendente Di \"arrivo\" = overflow");
            }
            else{
                for (;i<=n;i++){
                    System.out.println("\nL'Impiegato ID: "+ i + " Si Chiama: " + cognome[i-1] + " "+ nome[i-1] + " Ed Ha Uno Stipendio Mensile Pari A: "+ stipendio[i-1] + " Euro.");
                }
            }
        }
        else{
            System.out.println("MAX:" + max);
            for (;i<max;i++){
                    System.out.println("\nL'Impiegato ID: "+ (i+1) + " Si Chiama: " + cognome[i] + " "+ nome[i] + " Ed Ha Uno Stipendio Mensile Pari A: "+ stipendio[i] + " Euro.");
                }
        }
    }
    public int setIDipendente(){
        int ID;
        System.out.println("\nInserire Cognome Dipendente");
        String surname = input.nextLine();
        ID = trovaCognome(surname);
        System.out.println("\nInserire Nuovo ID Del Dipendente "+ surname +" Con ID Attuale:"+ ID);
        ID = input.nextInt();
        return ID;        
    }
    public void registraDipendenti(int n){
        int i;
        int num;
        num = trovaCognome("fine"); //Trovo Tappo Per Sovrapporlo
        for (i=0;i<n;i++){
            System.out.println("\n Inserire Nome Dipendente Numero "+ (i+1));
            nome[num] = this.stringPut();
            System.out.println("\n Inserire Cognome Dipendente Numero "+ (i+1));
            cognome[num] = input.nextLine();
            System.out.println("\n Inserire Salario Dipendente Numero "+ (i+1));
            stipendio[num] = this.doublePut();
            System.out.println("\nRegistrazioni Effettuate Con Successo Dipendente."+(i+1)+" Effettuata.");
            num+=1;    
        }
        cognome[num]="fine";    //Aggiungo Stringa Di Tappo In Vettore    
    }
    public void cambiaSalario(String surname, double schei){    //Cambio Salario In Base A Cognome(Non Accetta Cognomi Uguali)
        int ID;
        ID = trovaCognome(surname);
        stipendio[ID]=schei;
    }
    private int trovaCognome(String surname){   //Trovo Cognome
        int i;
        boolean check=false;
        for(i=0;check!=true;i++){
            if(cognome[i].equals(surname)){
                check=true;
            }
        }
        System.out.println("trovaCognome i: "+i);
        return (i-1);
    }
}
