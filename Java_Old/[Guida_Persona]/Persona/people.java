package Persona;

public class people{

	String nome;
	String cognome;
	
	/**
	* @PARAM Nome, Cognome
	**/
	public people(String name, String surname){
		this.nome=name;
		this.cognome=surname;
	}
	
	/**
	* @PARAM noParam
	**/
	public people(){
		this("","");
	}
	
	/**
	* @PARAM objectPeople
	**/
	public people(people tizio){
		this(tizio.nome,tizio.cognome);
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	/**
	* @PARAM Nome
	**/
	public void setNome(String name){
		this.nome=name;
	}
	
	/**
	* @PARAM Cognome
	**/
	public void setCognome(String surname){
		this.cognome=surname;
	}	
	
	/**
	* Override di toString
	* Ritorna una stringa (nome+cognome)
	* Richiamando direttamente l'oggetto nel print
	**/
	@Override
	public String toString(){
		return new String("Persona, Nome: "+nome+" Cognome: "+cognome);
	}
	
}