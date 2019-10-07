package com.accenture.biblio.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "genere")
public class Genere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codice_genere")
    private int codice_genere;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genere")
    private Set<Testo> listaTesti; 
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genere")
    private Set<Socio> listaSoci; 

    @Column(name = "descrizione")
    private String descrizione;

    public Genere() {

    }

    public int getCodice_genere() {
        return codice_genere;
    }

    public void setCodice_genere(int codice_genere) {
        this.codice_genere = codice_genere;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}