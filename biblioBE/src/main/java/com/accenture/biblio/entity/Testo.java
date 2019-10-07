package com.accenture.biblio.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.accenture.biblio.common.beans.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "testo")
public class Testo {
	
	@Id
    @Column(name = "codice_ISBN")
    private String codice_ISBN;
	
	@Column(name = "tipo")
    private char tipo;
	
	@Column(name = "titolo")
    private String titolo;
	
	@Column(name = "editore")
    private String editore;
	
	@ManyToOne
	@JoinColumn(name = "codice_genere") 
	private Genere genere; 	
	
	@OneToOne(mappedBy = "testo", cascade = CascadeType.ALL)
	private Libro libro;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "testo")
	private Set<Prestito> listaPrestito; 

	@Column(name = "data_Pubblicazione")
    private Date data_Pubblicazione;
	
	@Column(name = "data_Acquisizione")
    private Date data_Acquisizione;

	@Column(name = "flag_Prestito")
    private int flag_Prestito;
	
	
	
	public Testo() {

    }
	
	
	public Set<Prestito> getListaPrestito() {
		return listaPrestito;
	}

	public void setListaPrestito(Set<Prestito> listaPrestito) {
		this.listaPrestito = listaPrestito;
	}

	public String getCodice_ISBN() {
		return codice_ISBN;
	}

	public void setCodice_ISBN(String codice_ISBN) {
		this.codice_ISBN = codice_ISBN;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Date getData_Pubblicazione() {
		return data_Pubblicazione;
	}

	public void setData_Pubblicazione(Date data_Pubblicazione) {
		this.data_Pubblicazione = data_Pubblicazione;
	}

	public Date getData_Acquisizione() {
		return data_Acquisizione;
	}

	public void setData_Acquisizione(Date data_Acquisizione) {
		this.data_Acquisizione = data_Acquisizione;
	}

	public int getFlag_Prestito() {
		return flag_Prestito;
	}

	public void setFlag_Prestito(int flag_Prestito) {
		this.flag_Prestito = flag_Prestito;
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public void setTestoFromBean(TestoDTO testo, Genere genere)
	{
		this.setGenere(genere);
		this.setCodice_ISBN(testo.getCodice_ISBN());
		this.setData_Acquisizione(testo.getData_Acquisizione());
		this.setData_Pubblicazione(testo.getData_Pubblicazione());
		this.setEditore(testo.getEditore());
		this.setTipo(testo.getTipo());
		this.setTitolo(testo.getTitolo());
	}

}
