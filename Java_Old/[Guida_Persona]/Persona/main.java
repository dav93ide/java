package Persona;

public class main{

	public static void main(String[] args){
		people Individuo = new people();
		System.out.println(Individuo);
		Individuo.setNome("Guido");
		Individuo.setCognome("LaMoto");
		System.out.println(Individuo);
		people Individuo2 = new people(Individuo);
		System.out.println("Individuo2: "+Individuo2);
		Individuo2.setCognome("LaNave");
		System.out.println("Individuo2: "+Individuo2);
		people Individuo3 = new people("Carlo","Tarlo");
		System.out.println("Individuo3: "+Individuo3);
	}
}