package com.accenture.biblio.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@IdClass(PrestitoId.class)
@Table(name = "prestito")
public class Prestito{
	
	@Id  
	@Column(name = "codice_ISBN")
	private String codice_ISBN;

	@Id 
	@Column(name = "numero_Tessera")
	private Integer numero_Tessera;
	 
	@ManyToOne
	@JoinColumn(name = "codice_ISBN", insertable = false, updatable = false) 
	private Testo testo; 
	
	@ManyToOne
	@JoinColumn(name = "numero_Tessera", insertable = false, updatable = false) 
	private Socio socio; 
	
	@Column(name = "data_Prestito")
	private Date data_Prestito;
	
	@Column(name = "data_Scadenza")
	private Date data_Scadenza;
	
	@Column(name = "data_Restituzione")
	private Date data_Restituzione;
	
	public String getCodice_ISBN() {
		return codice_ISBN;
	}

	public void setCodice_ISBN(String codice_ISBN) {
		this.codice_ISBN = codice_ISBN;
	}

	public Integer getNumero_Tessera() {
		return numero_Tessera;
	}

	public void setNumero_Tessera(Integer numero_Tessera) {
		this.numero_Tessera = numero_Tessera;
	}

	public Testo getTesto() {
		return testo;
	}

	public void setTesto(Testo testo) {
		this.testo = testo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getData_Prestito() {
		return data_Prestito;
	}

	public void setData_Prestito(Date data_Prestito) {
		this.data_Prestito = data_Prestito;
	}

	public Date getData_Scadenza() {
		return data_Scadenza;
	}

	public void setData_Scadenza(Date data_Scadenza) {
		this.data_Scadenza = data_Scadenza;
	}

	public Date getData_Restituzione() {
		return data_Restituzione;
	}

	public void setData_Restituzione(Date data_Restituzione) {
		this.data_Restituzione = data_Restituzione;
	}
}
