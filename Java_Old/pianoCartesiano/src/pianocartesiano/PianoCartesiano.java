
package pianocartesiano;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class PianoCartesiano {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x;
        double y;
        boolean ctr = true;
        String str;
        System.out.println("\nAcquisizione Di 2 Punti");
        System.out.println("\nInserire Coordinate x Punto 1");
        x=input.nextDouble();
        System.out.println("\nInserire Coordinate y Punto 1");
        y=input.nextDouble();
        Punti point1 = new Punti(x,y);
        System.out.println("\nInserire Coordinate x Punto 2");
        x=input.nextDouble();
        System.out.println("\nInserire Coordinate y Punto 2");
        y=input.nextDouble();
        Punti point2 = new Punti(x,y);
        System.out.println("\nInserire Coordinate y Punto 2");
        do{
            System.out.println("Selezionare opzione:\n\t1]Distanza\n\t 2]Coefficiente Angolare\n\t3]Equazione Retta Passante\n\t4]Info Punti\n\t5]Cambia Coordinate\n\t6]Inserire Valori Retta\n\t7]Esci\n");
            str=input.nextLine();
            switch(str){
                case "Distanza":
                    double distanza;
                    distanza = Math.sqrt(Math.pow((point1.corX - point2.corX), 2.0) + Math.pow((point1.corY - point2.corY), 2.0));
                    System.out.println("\nLa Distanza Tra I Due Punti Equivale A: "+ distanza);
                break;
                case "Coefficiente Angolare":
                    double coef;
                    coef=(point1.corY + point2.corY)/(point1.corX + point2.corY);
                    System.out.println("\n Il Coefficiente Angolare Dei Punti Equivale A: "+ coef);
                break;
                case "Equazione Retta Passante":
                    double q;
                    q =((point1.corX/(point2.corX - point1.corX))*(point2.corY - point1.corY )) + point1.corY;
                    x =(point1.corY + point2.corY)/(point1.corX + point2.corY);
                    Retta retta = new Retta(x,1,q);
                    retta.infoEsp();                    
                break;
                case "Info Punti":
                    x=point1.corX();
                    y=point1.corY();
                    System.out.println("\nCoordinate Punto 1 x: " + x + " y: "+ y);
                    x=point2.corX();
                    y=point2.corY();
                    System.out.println("\nCoordinate Punto 2 x: "+x+" y: "+y);
                break;
                case "Cambia Coordinate":
                    System.out.println("Di Quale Punto Cambiare Coordinate? \n\t1]Uno\n\t2]Due\n\t3]Entrambi\n\t4]Annulla\n");
                    str = input.nextLine();
                    switch(str){
                        case "Uno":
                            System.out.println("\nSettaggio Coordinate Punto 1");
                            point1.changeCor();
                        break;
                        case "Due":
                            System.out.println("\nSettaggio Coordinate Punto 2");
                            point2.changeCor();
                        break;
                        case "Entrambi":
                            System.out.println("\nSettaggio Coordinate Punto 1");
                            point1.changeCor();
                            System.out.println("\nSettaggio Coordinate Punto 2");
                            point2.changeCor();
                        break;
                        case "Annulla":
                            System.out.println("\nOperazione Annullata cambiaCoordinate.Esci");
                        break;
                        default:
                            System.out.println("\nInserimento Non Valido");
                        break;
                    }
                    
                break;
                case "Inserire Valori Retta":
                    double c;
                    String str2;
                    System.out.println("\nForma Implicita. Inserire Valore Di ax");
                    x = input.nextDouble();
                    System.out.println("\nInserire Valore Di by");
                    y = input.nextDouble();
                    System.out.println("\nInserire Valore Di c");
                    c = input.nextDouble();
                    Retta retta1 = new Retta(x,y,c);
                    System.out.println("\nInserire Un Altra Retta? \n\t 1] Sì \n\t 2] No \n");
                    str2=input.nextLine();
                    if (str2.equals("Sì")){
                        System.out.println("\nForma Esplicita. Inserire Valore Di ax");
                        x = input.nextDouble();
                        System.out.println("\nInserire Valore Di by");
                        y = input.nextDouble();
                        System.out.println("\nInserire Valore Di c");
                        c = input.nextDouble();
                        Retta retta2 = new Retta(x,y,c);
                        System.out.println("Inserire Operazione: \n\t 1]Parallele \n\t 2] Perpendicolari \n\t 3]Distanza Rette \n\t 4]Esci");
                        str=input.nextLine();                     
                    }
                    else{
                        System.out.println("Inserire Operazione: \n\t 1]Distanza PuntoRetta \n\t 2]Punto Appartenente Retta \n\t 3]Esci \n");
                        str=input.nextLine();
                    }
                    switch(str){
                        case "Parallele":
                            double coef1,coef2;
                            coef1=retta1.coefM();
                            coef2=retta2.coefM();
                            if (coef1==coef2){
                                System.out.println("\nLe Due Rette r1: ");
                                retta1.infoImp();
                                System.out.println("\n r2: ");
                                retta2.infoImp();
                                System.out.prinln("\n Sono Parallele!");
                            }
                        break;
                        case "Perpendicolari":
                            double coef1,coef2;
                            coef1=retta1.coefM();
                            coef2=retta2.coefM();
                            if (coef1==(-(1/coef2))){
                                System.out.println("\nLe Due Rette r1: ");
                                retta1.infoImp();
                                System.out.println("\n r2: ");
                                retta2.infoImp();
                                System.out.prinln("\n Sono Perpendicolari!");
                            }
                        break;
                        case "Distanza Rette":
                            double zX,zY;
                            boolean ct = true;
                            Random rand = new Random();
                            for (;ct;){
                                zX=rand.nextDouble();
                                zY=rand.nextDouble();
                                q=retta1.retQ();
                                if(((zX*retta1.corX) + (zY*retta1.corY) + q)==0){
                                    ct=false;
                                    Punti pointDist = new Punti(zX,zY);
                                }
                            }
                            q= retta2.retQ();
                            distanza = Math.abs(((retta2.corX*pointDist.CorX)+(retta2.corY*pointDist.CorY) + q)/Math.sqrt((Math.pow(retta2.corX,2)+Math.pow(retta2.corY,2))));
                        break;
                        case "Distanza PuntoRetta":
                            System.out.println("Quale Punto Utilizzare? \n\t 1] Punto Uno \n\t 2] Punto Due \n");
                            
                        break;
                        case "Punto Appartenente Retta":
                        break;
                        case "Esci":
                        break;
                        default:
                            System.out.println("\nInserimento Non Valido.");
                        break;
                    }
                            
                    
                break;
                case "Esci": 
                    System.out.println("Run.Exit");
                    ctr = false;
                break;
                default: 
                    System.out.println("Inserimento Non Valido, Impara A Leggere.");
                break;
            }
        } while (ctr);
    }
}
