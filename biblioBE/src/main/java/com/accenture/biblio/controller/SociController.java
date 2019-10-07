package com.accenture.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.biblio.common.beans.Parametro;
import com.accenture.biblio.common.beans.Result;
import com.accenture.biblio.common.beans.SocioDTO;
import com.accenture.biblio.entity.Socio;
import com.accenture.biblio.service.GeneriService;
import com.accenture.biblio.service.SociService;

@RestController
@RequestMapping("/socio")
public class SociController {

	@Autowired
    private SociService sociService;
	
	@Autowired
    private GeneriService generiService;
	
	@RequestMapping(value = "/saveSocio", method = RequestMethod.POST, headers = "Accept=application/json")
    public Result saveSocio(@RequestBody SocioDTO socio) {	
		Result result = new Result();
		Socio socioDao = new Socio();
        socioDao.setCodice_Fiscale(socio.getCodice_Fiscale());
        socioDao.setData_Iscrizione(socio.getData_Iscrizione());
        socioDao.setGenere(generiService.getGenere(socio.getCodice_genere()));
        socioDao.setNome_Cognome(socio.getNome() + " " + socio.getCognome());
        socioDao.setTesti_Prestito(0);
        socioDao.setTelefono(socio.getTelefono());
    	if(sociService.seveSocio(socioDao)) {
    		result.setMessaggio("Salvataggio avvenuto con successo!");
    		result.setTipoMessaggio("success");
    	}
    	else {
    		result.setMessaggio("Salvataggio fallito, socio già presente!");
    		result.setTipoMessaggio("error");
    	}
    	return result;
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
   	public ResponseEntity<List<Socio>> listAllSoci() {
   		List<Socio> soci = sociService.getSoci();
   		if(soci.isEmpty()){
   			return new ResponseEntity<List<Socio>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Socio>>(soci, HttpStatus.OK);
   	}
	
	@RequestMapping(value = "/getSocio", method = RequestMethod.POST)
   	public ResponseEntity<Socio> getSocio(@RequestBody Parametro parametro) {
			Socio socio = sociService.getSocio(parametro.getParametroNumerico());
   		if(socio == null){
   			return new ResponseEntity<Socio>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<Socio>(socio, HttpStatus.OK);
   	}
	
	@RequestMapping(value = "/deleteSocio", method = RequestMethod.POST)
   	public Result deleteSocio(@RequestBody SocioDTO socio) {
		Result result = new Result();
		
		if(sociService.deleteSocio(socio.getNumero_Tessera())) {
    		result.setMessaggio("Cancellazione avvenuta con successo!");
    		result.setTipoMessaggio("success");
    	}
    	else {
    		result.setMessaggio("Cancellazione fallita!");
    		result.setTipoMessaggio("error");
    	}
    	return result;
   		}
	
	@RequestMapping(value = "/updateSocio", method = RequestMethod.POST)
   	public Result updateSocio(@RequestBody SocioDTO socio) {
		Result result = new Result();
		Socio socioDao = new Socio();
		
		socioDao.setNumero_Tessera(socio.getNumero_Tessera());
		socioDao.setCodice_Fiscale(socio.getCodice_Fiscale());
		socioDao.setData_Iscrizione(socio.getData_Iscrizione());
		socioDao.setGenere(generiService.getGenere(socio.getCodice_genere()));
		socioDao.setNome_Cognome(socio.getNome() + socio.getCognome());
		socioDao.setTelefono(socio.getTelefono());
		socioDao.setTesti_Prestito(socio.getTesti_Prestito());
		
		if(sociService.updateSocio(socioDao)) {
    		result.setMessaggio("Modifica avvenuta con successo!");
    		result.setTipoMessaggio("success");
    	}
    	else {
    		result.setMessaggio("Modifica fallita!");
    		result.setTipoMessaggio("error");
    	}
    	return result;
   		}
	
}
