package com.accenture.biblio.service;

import java.util.List;

import com.accenture.biblio.entity.Prestito;

public interface PrestitiService {
	
	public Boolean savePrestito(Prestito prestito);
	
	public List <Prestito> getPrestiti(String codiceISBN);
}
