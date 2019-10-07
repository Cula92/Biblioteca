package com.accenture.biblio.controller;

import java.sql.Date;
import java.util.Calendar;
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
import com.accenture.biblio.entity.Prestito;
import com.accenture.biblio.entity.Socio;
import com.accenture.biblio.entity.Testo;
import com.accenture.biblio.service.PrestitiService;
import com.accenture.biblio.service.SociService;
import com.accenture.biblio.service.TestiService;

@RestController
@RequestMapping("/prestito")
public class PrestitiController {
	
	@Autowired
    private SociService sociService;
	
	@Autowired
    private TestiService testiService;
	
	@Autowired
    private PrestitiService prestitiService;
	
	@RequestMapping(value = "/restituzioneTesto", method = RequestMethod.POST, headers = "Accept=application/json")
    public Result restituzioneTesto(@RequestBody Parametro parametro) {	
		Result result = new Result();
		Prestito prestitoDao = new Prestito();
		Testo testoDao;
		Socio socioDao;
		Date data = new Date(System.currentTimeMillis());
		List<Prestito> prestiti = prestitiService.getPrestiti(parametro.getParametroRicerca());
		
		if(!prestiti.isEmpty()) {
				//prestitoDao.setCodice_ISBN(prestiti.get(0).getCodice_ISBN());
				//prestitoDao.setNumero_Tessera(prestiti.get(0).getNumero_Tessera());
				//prestitoDao.setData_Prestito(prestiti.get(0).getData_Prestito());
				//prestitoDao.setData_Scadenza(prestiti.get(0).getData_Scadenza());
				prestiti.get(0).setData_Restituzione(data);
				
				testoDao = testiService.getTesto(prestiti.get(0).getCodice_ISBN());
				testoDao.setFlag_Prestito(0);
				
				socioDao = sociService.getSocio(prestiti.get(0).getNumero_Tessera());
				socioDao.setTesti_Prestito(socioDao.getTesti_Prestito() - 1);
				
				prestitiService.savePrestito(prestiti.get(0));
				sociService.updatePrestitoSocio(socioDao);
		    	testiService.updateTesto(testoDao);
		    		
		    	result.setMessaggio("Il testo è stato restituito con successo!");
		    	result.setTipoMessaggio("success");
		}
		else
		{
			result.setMessaggio("Errore!");
    		result.setTipoMessaggio("error");
		}
		return result;
	}
	
	@RequestMapping(value = "/savePrestito", method = RequestMethod.POST, headers = "Accept=application/json")
    public Result savePrestito(@RequestBody Parametro parametro) {	
		
		Result result = new Result();
		Prestito prestitoDao = new Prestito();
		Testo testoDao = new Testo();
		Socio socioDao = new Socio();
		Date data = new Date(System.currentTimeMillis());
		Date dataScadenza = new Date((long) (System.currentTimeMillis() + 5.184e+9));
		
		testoDao = testiService.getTesto(parametro.getParametroRicerca());
		socioDao = sociService.getSocio(parametro.getParametroNumerico());
		
		if(socioDao.getTesti_Prestito() < 3) {
				testoDao.setFlag_Prestito(1);
				socioDao.setTesti_Prestito(socioDao.getTesti_Prestito() + 1);
	    		prestitoDao.setNumero_Tessera(socioDao.getNumero_Tessera());
	    		prestitoDao.setCodice_ISBN(testoDao.getCodice_ISBN());
	    		prestitoDao.setData_Prestito(data);
	    		prestitoDao.setData_Scadenza(dataScadenza);
				if(prestitiService.savePrestito(prestitoDao)) {
		    		result.setMessaggio("Il salvataggio del prestito è avvenuto con successo!");
		    		result.setTipoMessaggio("success");
		    		sociService.updatePrestitoSocio(socioDao);
		    		testiService.updateTesto(testoDao);
		    	}
		    	else {
		    		result.setMessaggio("Salvataggio fallito!");
		    		result.setTipoMessaggio("error");
		    	}
		}
		else{
			result.setMessaggio("Il socio ha raggiunto il numero massimo di prestiti!");
    		result.setTipoMessaggio("error");
		}
    	return result;
	}

}
