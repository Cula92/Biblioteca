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

import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.common.beans.SocioDTO;
import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Socio;

@Repository	
public class SociDAOImpl implements SociDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
    public Boolean saveSocio(Socio socio) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(socio);
        if(currentSession.find(Socio.class, socio.getNumero_Tessera()) != null) {
        	return true;
        }
        else
        	return false;
        
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List < Socio > getSoci() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Socio > cq = cb.createQuery(Socio.class);
        Root < Socio > root = cq.from(Socio.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
	
	@Override
	public Socio getSocio(Integer numero_Tessera) {
		 Session currentSession = sessionFactory.getCurrentSession();
	     Socio socio = currentSession.get(Socio.class, numero_Tessera);
	     return socio;
	}
	
	@Override
    public Boolean deleteSocio(Integer numero_Tessera) {
    	Session session = sessionFactory.getCurrentSession();
    	session.delete(getSocio(numero_Tessera));
    	if(session.find(Socio.class, numero_Tessera) != null)
        	return false;
        else
        	return true;
    }
	
	@Override
    public Boolean updateSocio(Socio socio) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(socio);
        if(currentSession.find(Socio.class, socio.getNumero_Tessera()) != null)
        	return true;
        else
        	return false;
    }
	
	@Override
    public Boolean updatePrestitoSocio(Socio socio) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(socio);
        return true;
    }
}
