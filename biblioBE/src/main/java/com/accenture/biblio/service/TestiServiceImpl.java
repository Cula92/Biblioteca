package com.accenture.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.dao.TestiDAO;
import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Testo;

@Service
public class TestiServiceImpl implements TestiService{
	
	@Autowired
    private TestiDAO testiDAO;

    @Override
    @Transactional
    public List < Testo > getTesti() {
        return testiDAO.getTesti();
    }
    
    @Override
    @Transactional
    public List < Testo > getTestiLibri() {
        return testiDAO.getTestiLibri();
    }
    
    @Override
    @Transactional
    public List < Testo > getTestiRiviste() {
        return testiDAO.getTestiRiviste();
    }
    
    @Override
    @Transactional
    public Boolean saveTesto(Testo testo) {
    	return testiDAO.saveTesto(testo);
    }
    
    @Override
    @Transactional
    public Testo getTesto(String codiceISBN) {
        return testiDAO.getTesto(codiceISBN);
    }
    
    @Override
    @Transactional
    public Boolean deleteTesto(String codiceISBN) {
        return testiDAO.deleteTesto(codiceISBN);
    }
    
    @Override
    @Transactional
    public Boolean updateTesto(Testo testo) {
    	return testiDAO.updateTesto(testo);
    }
}
