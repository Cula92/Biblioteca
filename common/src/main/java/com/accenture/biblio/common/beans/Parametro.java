package com.accenture.biblio.common.beans;

import java.sql.Date;

public class Parametro {
	
	private String parametroRicerca;
	
	private String parametroRicerca1;
	
	private Integer parametroNumerico;
	
	private Date parametroData;
	
	public Parametro() {
		
	}	
	
	public Date getParametroData() {
		return parametroData;
	}

	public void setParametroData(Date parametroData) {
		this.parametroData = parametroData;
	}

	public Integer getParametroNumerico() {
		return parametroNumerico;
	}

	public void setParametroNumerico(Integer parametroNumerico) {
		this.parametroNumerico = parametroNumerico;
	}

	public String getParametroRicerca1() {
		return parametroRicerca1;
	}

	public void setParametroRicerca1(String parametroRicerca1) {
		this.parametroRicerca1 = parametroRicerca1;
	}

	public String getParametroRicerca() {
		return parametroRicerca;
	}

	public void setParametroRicerca(String parametroRicerca) {
		this.parametroRicerca = parametroRicerca;
	}
}
