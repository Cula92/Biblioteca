package com.accenture.biblio.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "socio")
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_Tessera")
	private Integer numero_Tessera;

	@Column(name = "codice_Fiscale")
	private String codice_Fiscale;
	
	@Column(name = "nome_Cognome")
	private String nome_Cognome;
	
	@Column(name = "telefono")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "codice_Genere") 
	private Genere genere; 	
	
	@Column(name = "data_Iscrizione")
	private Date data_Iscrizione;
	
	@Column(name = "testi_Prestito")
	private Integer testi_Prestito;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "socio")
	private Set<Prestito> listaPrestito; 

	public Set<Prestito> getListaPrestito() {
		return listaPrestito;
	}

	public void setListaPrestito(Set<Prestito> listaPrestito) {
		this.listaPrestito = listaPrestito;
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

	public String getNome_Cognome() {
		return nome_Cognome;
	}

	public void setNome_Cognome(String nome_Cognome) {
		this.nome_Cognome = nome_Cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Date getData_Iscrizione() {
		return data_Iscrizione;
	}

	public void setData_Iscrizione(Date data_Iscrizione) {
		this.data_Iscrizione = data_Iscrizione;
	}

	public Integer getTesti_Prestito() {
		return testi_Prestito;
	}

	public void setTesti_Prestito(Integer testi_Prestito) {
		this.testi_Prestito = testi_Prestito;
	}
	
}
