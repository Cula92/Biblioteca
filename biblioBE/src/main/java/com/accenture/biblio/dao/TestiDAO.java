package com.accenture.biblio.dao;

import java.util.List;

import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Testo;

public interface TestiDAO {
	
	 public List < Testo > getTesti();
	 
	 public List<Testo> getTestiLibri();
	 
	 public List < Testo > getTestiRiviste();
	    
	 public Boolean saveTesto(Testo testo);

	 public Testo getTesto(String codiceISBN);
	    
	 public Boolean deleteTesto(String codiceISBN);
	 
	 public Boolean updateTesto(Testo testo);
}
