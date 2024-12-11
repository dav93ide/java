import java.util.Scanner;
package Guida;


public class main{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Inserire Posizione Di Partenza [Double]");
		double Posizione = input.nextDouble();
		System.out.println("Inserire Marcia Di Partenza [Int]");
		int Marcia = input.nextInt();
		macchina Car = new macchina(Posizione,Marcia);
		while (choose!=0){
			int choose;
			System.out.println("Inserire Rispettivo Valore Numerico: \n\t1] Vai A Destra \n\t2] Vai A Sinistra \n\t3] Aggiungi Marcia \n\t4] Scala Marcia \n\t5] Marcia Attuale \n\t6] Posizione Algebrica Attuale \n\t7] Informazioni \n\t0] Esci");
			switch(choose){
				case 0:
					System.out.println("Uscita");
				break;	
				case 1:
					System.out.println("Inserire Spostamento Verso Destra");
					Posizione = input.nextDouble();
					Car.vaiADx(Posizione);
				break;
				case 2:
					System.out.println("Inserire Spostamento Verso Sinistra");
					Posizione = input.nextDouble();
					Car.vaiASx(Posizione);
				break;
				case 3:
					Car.marciaPlus();
				break;
				case 4:
					Car.marciaMinus();
				break;
				case 5:
				break;
				case 6:
				break;
				case 7:
					System.out.println(Car);
				break;
				default:
					System.out.println("Inserimento Non Corretto");
				break;
		}
	}
}