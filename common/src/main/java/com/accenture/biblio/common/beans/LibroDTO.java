package com.accenture.biblio.common.beans;


public class LibroDTO {
	
	private String codice_ISBN;

	private String autore;
	
	private String Collana;
	
	public LibroDTO(){
		
	}
	
	public String getCodice_ISBN() {
		return codice_ISBN;
	}

	public void setCodice_ISBN(String codice_ISBN) {
		this.codice_ISBN = codice_ISBN;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCollana() {
		return Collana;
	}

	public void setCollana(String collana) {
		Collana = collana;
	}
}
