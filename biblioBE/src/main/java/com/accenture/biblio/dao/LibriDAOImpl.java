package com.accenture.biblio.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Libro;

@Repository	
public class LibriDAOImpl implements LibriDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
    public int saveLibro(Libro libro) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(libro);
        return 0;
    }
	
	@Override
    public Libro getLibro(String id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Libro libro = currentSession.get(Libro.class, id);
        return libro;
    }

}
