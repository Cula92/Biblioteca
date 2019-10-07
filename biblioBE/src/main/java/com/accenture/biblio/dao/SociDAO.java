package com.accenture.biblio.dao;

import java.util.List;

import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.common.beans.SocioDTO;
import com.accenture.biblio.entity.Socio;

public interface SociDAO {
	
	public Boolean saveSocio(Socio socio);
	
	public List <Socio> getSoci();
	
	public Socio getSocio(Integer numero_Tessera);
	
	public Boolean deleteSocio(Integer numero_Tessera);
	
	public Boolean updateSocio(Socio socio);
	
	public Boolean updatePrestitoSocio(Socio socio);
}
