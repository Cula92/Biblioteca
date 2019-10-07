package com.accenture.biblio.common.beans;

import java.sql.Date;

public class SocioDTO {
	
	private Integer numero_Tessera;

	private String nome;
	
	private String cognome;
	
	private String codice_Fiscale;
	
	private String telefono;
	
	private int codice_genere;
	
	private Date data_Iscrizione;
	
	private Integer testi_Prestito;
	
	public Integer getTesti_Prestito() {
		return testi_Prestito;
	}

	public void setTesti_Prestito(Integer testi_Prestito) {
		this.testi_Prestito = testi_Prestito;
	}

	public Integer getNumero_Tessera() {
		return numero_Tessera;
	}

	public void setNumero_Tessera(Integer numero_Tessera) {
		this.numero_Tessera = numero_Tessera;
	}

	public String getCodice_Fiscale() {
		return codice_Fiscale;
	}

	public void setCodice_Fiscale(String codice_Fiscale) {
		this.codice_Fiscale = codice_Fiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCodice_genere() {
		return codice_genere;
	}

	public void setCodice_genere(int codice_genere) {
		this.codice_genere = codice_genere;
	}

	public Date getData_Iscrizione() {
		return data_Iscrizione;
	}

	public void setData_Iscrizione(Date data_Iscrizione) {
		this.data_Iscrizione = data_Iscrizione;
	}
}
