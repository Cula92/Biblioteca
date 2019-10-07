package com.accenture.biblio.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.biblio.entity.Genere;

@Repository	
public class GeneriDAOImpl implements GeneriDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List < Genere > getGeneri() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Genere > cq = cb.createQuery(Genere.class);
        Root < Genere > root = cq.from(Genere.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    
    @Override
    public int saveGenere(Genere genere) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Genere> listaGeneri = getGeneri();
        for(Genere element: listaGeneri)
        {
        	if(element.getDescrizione().toLowerCase().equals(genere.getDescrizione().toLowerCase()))
        	{
        		return -1;
        	}
        }
        currentSession.saveOrUpdate(genere);
        return 0;
    }

    @Override
    public Genere getGenere(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Genere genere = currentSession.get(Genere.class, id);
        return genere;
    }
    
    @Override
    public Genere eliminateGenere(Genere genere) {
    	Session session = sessionFactory.getCurrentSession();
    	session.delete(genere);
    	return genere;
    }

}
