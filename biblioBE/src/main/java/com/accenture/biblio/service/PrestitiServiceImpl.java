package com.accenture.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.biblio.dao.PrestitiDAO;
import com.accenture.biblio.entity.Prestito;

@Service
public class PrestitiServiceImpl implements PrestitiService{
	
	@Autowired
    private PrestitiDAO prestitiDAO;

	@Override
    @Transactional
    public Boolean savePrestito(Prestito prestito) {
    	return prestitiDAO.savePrestito(prestito);
    }
	
	@Override
    @Transactional
    public List <Prestito> getPrestiti(String codiceISBN) {
    	return prestitiDAO.getPrestiti(codiceISBN);
    }
}
