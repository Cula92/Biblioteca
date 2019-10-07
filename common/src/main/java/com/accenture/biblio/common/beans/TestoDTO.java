package com.accenture.biblio.common.beans;

import java.sql.Date;


public class TestoDTO {

	private String codice_ISBN;
	
    private char tipo;
	
    private String titolo;
	
    private String editore;
	
    private int codice_genere;
	
    private Date data_Pubblicazione;
	
    private Date data_Acquisizione;
	
    private int flag_Prestito;
    
    private String autore;

	private String collana;

	    public TestoDTO() {

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

		public int getCodice_genere() {
			return codice_genere;
		}

		public void setCodice_genere(int codice_genere) {
			this.codice_genere = codice_genere;
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

}
