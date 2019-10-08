	package com.accenture.biblio.dao;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.biblio.entity.Prestito;
import com.accenture.biblio.entity.PrestitoId;
import com.accenture.biblio.entity.Testo;

@Repository	
public class PrestitoDAOImpl implements PrestitiDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
		
    @SuppressWarnings("unchecked")
	@Override
    public Prestito getPrestiti(String codiceISBN) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Prestito > cq = cb.createQuery(Prestito.class);
        Root < Prestito > root = cq.from(Prestito.class);
        cq.select(root).where(cb.and(cb.equal(root.get("codice_ISBN"), codiceISBN), cb.isNull(root.get("data_Restituzione"))));
        Query query = session.createQuery(cq);
        return (Prestito) query.getResultList().get(0);
    }
	
	@Override
	public Boolean savePrestito(Prestito prestito) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		PrestitoId pk = new PrestitoId(prestito.getCodice_ISBN(), prestito.getNumero_Tessera());
		
		if(currentSession.find(Prestito.class,  pk) != null) {
			currentSession.merge(prestito);
		}
		else {
			currentSession.save(prestito);
		}
		return true;
	}
	
}
