package com.accenture.biblio.dao;

import java.util.List;

import com.accenture.biblio.entity.Prestito;

public interface PrestitiDAO {
	
	public Boolean savePrestito(Prestito prestito);
	
	public Prestito getPrestiti(String codiceISBN);
}
