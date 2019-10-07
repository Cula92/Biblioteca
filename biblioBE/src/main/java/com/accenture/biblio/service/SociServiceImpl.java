package com.accenture.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.common.beans.SocioDTO;
import com.accenture.biblio.dao.GeneriDAO;
import com.accenture.biblio.dao.SociDAO;
import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Socio;

@Service
public class SociServiceImpl implements SociService{
	
	@Autowired
    private SociDAO sociDAO;

	@Override
	@Transactional
	public Boolean seveSocio(Socio socio) {
		return sociDAO.saveSocio(socio);
	}
	
	@Override
	@Transactional
	public List <Socio> getSoci() {
		return sociDAO.getSoci();
	}
	
	@Override
	@Transactional
	public Socio getSocio(Integer numero_Tessera) {
		return sociDAO.getSocio(numero_Tessera);
	}
	
	@Override
	@Transactional
	public Boolean deleteSocio(Integer numero_Tessera) {
		return sociDAO.deleteSocio(numero_Tessera);
	}
	
	@Override
	@Transactional
	public Boolean updateSocio(Socio socio) {
		return sociDAO.updateSocio(socio);
	}
	
	@Override
	@Transactional
	public Boolean updatePrestitoSocio(Socio socio) {
		return sociDAO.updateSocio(socio);
	}
}
