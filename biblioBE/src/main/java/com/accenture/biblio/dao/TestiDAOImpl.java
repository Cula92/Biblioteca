package com.accenture.biblio.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Libro;
import com.accenture.biblio.entity.Testo;

@Repository	
public class TestiDAOImpl implements TestiDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List < Testo > getTesti() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Testo > cq = cb.createQuery(Testo.class);
        Root < Testo > root = cq.from(Testo.class);
        cq.select(root).orderBy(cb.asc(root.get("codice_ISBN")));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List < Testo > getTestiLibri() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Testo > cq = cb.createQuery(Testo.class);
        Root < Testo > root = cq.from(Testo.class);
        //Root < Libro > root1 = cq.from(Libro.class);
        //cq.multiselect(root, root1);
        //cq.where(cb.equal(root.get("codice_ISBN"), root1.get("codice_ISBN")));
        cq.select(root).where(cb.equal(root.get("tipo"), 'L'));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List < Testo > getTestiRiviste() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Testo > cq = cb.createQuery(Testo.class);
        Root < Testo > root = cq.from(Testo.class);
        cq.select(root).where(cb.equal(root.get("tipo"), 'R'));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    
    @Override
    public Boolean saveTesto(Testo testo) {
        Session session = sessionFactory.getCurrentSession();
        if(session.find(Testo.class, testo.getCodice_ISBN()) == null){
        	session.save(testo);
        	return true;
        }
        else
        	return false;
    }

    @Override
    public Testo getTesto(String codiceISBN) {
        Session session = sessionFactory.getCurrentSession();
        Testo testo = session.get(Testo.class, codiceISBN);
        return testo;
    }
    
    @Override
    public Boolean deleteTesto(String codiceISBN) {
    	Session session = sessionFactory.getCurrentSession();
    	Testo testo = getTesto(codiceISBN);
    	if(testo != null) {
    		session.delete(testo);
    		return true;
    	}
    	else 
    		return false;
    }
    
    @Override
    public Boolean updateTesto(Testo testo) {
        Session session = sessionFactory.getCurrentSession();
        	session.update(testo);
        	return true;
    }

}
