package com.accenture.biblio.common.beans;

public class Result {
	
	private String messaggio;
	
	private Integer numero_Tessera;
	
	private String tipoMessaggio;

	public String getTipoMessaggio() {
		return tipoMessaggio;
	}

	public void setTipoMessaggio(String tipoMessaggio) {
		this.tipoMessaggio = tipoMessaggio;
	}

	public Integer getNumero_Tessera() {
		return numero_Tessera;
	}

	public void setNumero_Tessera(Integer numero_Tessera) {
		this.numero_Tessera = numero_Tessera;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
}
