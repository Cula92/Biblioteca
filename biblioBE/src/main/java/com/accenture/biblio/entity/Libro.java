package com.accenture.biblio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@Column(name = "codice_ISBN")
	private String codice_ISBN;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	@JoinColumn(name = "codice_ISBN")
	private Testo testo;

	@Column(name = "autore")
    private String autore;
    
    @Column(name = "collana")
    private String collana;

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCollana() {
		return collana;
	}

	public void setCollana(String collana) {
		this.collana = collana;
	}
	
	public String getCodice_ISBN() {
		return codice_ISBN;
	}

	public void setCodice_ISBN(String codice_ISBN) {
		this.codice_ISBN = codice_ISBN;
	}

	public Testo getTesto() {
		return testo;
	}

	public void setTesto(Testo testo) {
		this.testo = testo;
	}
	
	public void setLibroFromTesto(Testo testo, String collana, String autore) {
		this.setTesto(testo);
		this.setAutore(autore);
		this.setCollana(collana);
	}
}
