package com.accenture.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.biblio.dao.*;
import com.accenture.biblio.entity.*;


@Service
public class GeneriServiceImpl implements GeneriService{
	
	@Autowired
    private GeneriDAO generiDAO;

    @Override
    @Transactional
    public List < Genere > getGeneri() {
        return generiDAO.getGeneri();
    }
    
    @Override
    @Transactional
    public int saveGenere(Genere genere) {
    	return generiDAO.saveGenere(genere);
    }
    
    @Override
    @Transactional
    public Genere getGenere(int theId) {
        return generiDAO.getGenere(theId);
    }
    
    @Override
    @Transactional
    public Genere eliminateGenere(Genere genere) {
        return generiDAO.eliminateGenere(genere);
    }
}
