package com.accenture.biblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.biblio.dao.LibriDAO;
import com.accenture.biblio.entity.Libro;

@Service
public class LibriServiceImpl implements LibriService{
	
	@Autowired
	private LibriDAO libriDAO;
	
	@Override
    @Transactional
    public int saveLibro(Libro libro) {
    	return libriDAO.saveLibro(libro);
    }
	
	@Override
    @Transactional
    public Libro getLibro(String id) {
    	return libriDAO.getLibro(id);
    }
}
