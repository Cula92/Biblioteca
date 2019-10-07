package com.accenture.biblio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@SuppressWarnings("serial")
public class PrestitoId implements Serializable{
	
	private String codice_ISBN;
		
	private Integer numero_Tessera;
    
    public PrestitoId() {	
    }
	
	public String getCodice_ISBN() {
		return codice_ISBN;
	}

	public Integer getNumero_Tessera() {
		return numero_Tessera;
	}
	
    public void setCodice_ISBN(String codice_ISBN) {
		this.codice_ISBN = codice_ISBN;
	}

	public void setNumero_Tessera(Integer numero_Tessera) {
		this.numero_Tessera = numero_Tessera;
	}

	
	public PrestitoId(String codice_ISBN, Integer numero_Tessera) {
		this.codice_ISBN = codice_ISBN;
		this.numero_Tessera = numero_Tessera;
	}
	
}
