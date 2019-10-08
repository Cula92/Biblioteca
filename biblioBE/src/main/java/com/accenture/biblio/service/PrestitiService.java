package com.accenture.biblio.service;

import java.util.List;

import com.accenture.biblio.entity.Prestito;

public interface PrestitiService {
	
	public Boolean savePrestito(Prestito prestito);
	
	public Prestito getPrestiti(String codiceISBN);
}
