/* Davide Savian
 Convegno Medicina, IV Informatica Serale
 ** Ho Commentato Al Meglio Possibile Il Programma Per Spiegarne Il Funzionamento**
 ** Funzionante, Testato Su OS Linux Usando NetBeans IDE 8.0.2**
 */
package convegnomedicina;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ConvegnoMedicina {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ARelatori> listRel = new ArrayList();     // Dichiaro E Inizializzo Array List Per Avere Un Numero Non Specificato Di Oggetti Di Tipo "Medici O Relatori"
        while (true) {
            System.out.println("Selezionare Un'Operazione: \n\t1]Aggiungere Relatori");
            if (!listRel.isEmpty()) {     // Se listRel E`Vuota Non Ha Senso Visualizzare La Possibilita`Di Modificarne Gli Elementi
                System.out.print("\t2]Aggiungere Interventi\n\t3]Stampare Tutti Interventi\n\t4]Stampare Interventi Di Un Relatore E Sua Media Voti\n\t5]Cerca Intervento\n\t0]End Program \n\t\t(Int From 0 To 5)\n");
            }
            int iChoose = input.nextInt();
            input.nextLine();       // Notando che Sul Mio Pc Dopo Un "input.nextInt()" Il Successivo "input.nextLine()" Veniva Ignorato Ho Inserito Degli "input.nextLine()" In Modo Da Non Ignorare Il Successivo,
            // Il Commento "// **" Da Ora In Avanti Stara` Ad Indicare Questa Situazione; Qualora Nell'OS Su Cui Eseguito Il Programma Non Vi Fosse Tale Problema Basti Eliminare Le Parti Con Tale Commento.
            switch (iChoose) {      // Switch-Case Su iChoose
                case 0:
                    System.exit(0);     // iChoose == 0 : Esci Dal Programma
                    break;
                case 1:
                    while (true) {      // Ciclo Infinito Per Incogniti Inserimenti
                        String sName, sSurname, sNat;
                        System.out.println("Inserire Codice Relatore (End To Break Cycle)");
                        String sCode = input.nextLine();
                        if (sCode.equals("End")) {      // Se sCode = "End" Esco Dal Ciclo While
                            break;
                        } else {
                            System.out.println("Inserire Nome Relatore");
                            sName = input.nextLine();
                            System.out.println("Inserire Cognome Relatore");
                            sSurname = input.nextLine();
                            System.out.println("Inserire Nazionalita`Relatore");
                            sNat = input.nextLine();
                            System.out.println("Medico o Ricercatore?");
                            String sChoose = input.nextLine();
                            if (sChoose.contains("edico")) {    // Creo Un Oggetto "Medici" O Un Oggetto "Ricercatori"
                                String nameHospital, locHospital;
                                System.out.println("Inserire Nome Ospedale Di Provenienza");
                                nameHospital = input.nextLine();
                                System.out.println("Inserire Luogo Ospedale Di Provenienza");
                                locHospital = input.nextLine();
                                listRel.add(new Medici(nameHospital, locHospital, sCode, sName, sSurname, sNat));
                            } else {
                                int nP;
                                System.out.println("Inserire Numero Pubblicazioni Ricercatore");
                                nP = input.nextInt();
                                listRel.add(new Ricercatori(nP, sCode, sName, sSurname, sNat));
                                input.nextLine(); // **
                            }
                        }
                    }
                    break;
                case 2:
                    while (true) {  // While Infinito
                        System.out.println("Inserire Numero Corrispondente Al Relatore Per Inserire Rispettivi Interventi Con Voti(0 To Break Cycle)");
                        for (int i = 0; i < listRel.size(); i++) {
                            System.out.println((i + 1) + "]\tNome: " + listRel.get(i).getNameRel() + "\tCognome: " + listRel.get(i).getSurnameRel() + "\t Codice: " + listRel.get(i).getCodeRel());
                        }
                        int nRel = input.nextInt();
                        input.nextLine(); // **
                        if (nRel == 0) {    // Se nRel = 0 Esco Dal While
                            break;
                        } else {
                            nRel--; // Diminuisco Di 1 Il Valore Di nRel Per Avere Posizione Corrispondente Su listRel
                            while (true) {  // While Infinito
                                System.out.println("Inserire Titolo Intervento (End To Break Cycle)");
                                String sTitle = input.nextLine();
                                if (sTitle.equals("End")) {     // Se sTitle = "End" Esco Da While
                                    break;
                                } else {
                                    System.out.println("Inserire Rispettivamente Anno, Mese, Giorno,Ora,Minuti e Voto Intervento");
                                    GregorianCalendar cData = new GregorianCalendar(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());   // Creo Oggetto GregorianCalendar Con Input Per Anno,Mese,Giorno,Ora,Minuti Su Parametri Costruttore
                                    int iVote = input.nextInt();
                                    Intervento iNew = new Intervento(cData, sTitle, listRel.get((nRel)), iVote); // Creo Oggetti Intervento
                                    input.nextLine(); // **
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (ARelatori rel : listRel) {     // Itero listRel E Stampo Per Ogni Oggetto (Medici O Relatori) La Lista Degli Interventi
                        rel.printInterventi();
                    }
                    break;
                case 4:
                    System.out.println("Inserire Nome Relatore");
                    String sName = input.nextLine();
                    System.out.println("Inserire Cognome Relatore");
                    String sSurname = input.nextLine();
                    int i = 0;
                    for (; i < listRel.size(); i++) {
                        if (listRel.get(i).getNameRel().equals(sName) & listRel.get(i).getSurnameRel().equals(sSurname)) {  // Se Nome E Cognome Corrispondono Stampo Interventi E Media Voti, Infine Esco Dal For
                            listRel.get(i).printInterventi();
                            System.out.println("Media Voti: " + listRel.get(i).mediaVotiInt());
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Inserire Titolo Intervento");
                    String sTitle = input.nextLine();
                    for (ARelatori rel : listRel) {   // Primo For: Itero listRel Tramite Iteratore "rel" ( = ARelatori)
                        ArrayList<Intervento> IList = new ArrayList(rel.getInterventi()); // Creo Un ArrayList Per Lista Interventi Di Ogni Relatore
                        for (i = 0; i < IList.size(); i++) {   // Secondo For: Tramite Metodo ".getInterventi()" Ottengo ArrayList Interventi Per Ogni Relatori Di listRel E Assegno Tale ArrayList A IList
                            if (IList.get(i).getTitle().equals(sTitle)) {     // Se Elemento "i" Di IList Ha Titolo Uguale A Titolo Inserito Stampo Informazioni Intervento E Interrompo Il For
                                System.out.println("Informazioni Intervento: \n" + IList.get(i).toString());
                                break;
                            }
                        }
                    }
            }
        }
    }

}
