package com.accenture.biblio.controller;

import java.util.Collections;
import java.util.List;

import com.accenture.biblio.common.beans.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.entity.Libro;
import com.accenture.biblio.entity.Testo;
import com.accenture.biblio.service.GeneriService;
import com.accenture.biblio.service.LibriService;
import com.accenture.biblio.service.TestiService;

@RestController
@RequestMapping("/testo")
public class TestiController {
	
	@Autowired
    private TestiService testiService;
	
	@Autowired
    private GeneriService generiService;
	
	@Autowired
    private LibriService libriService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
   	public ResponseEntity<List<Testo>> listAllTesti() {
   		List<Testo> testi = testiService.getTesti();
   		if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@RequestMapping(value = "/listTestiDisponibili", method = RequestMethod.GET)
   	public ResponseEntity<List<Testo>> listAllTestiDisponibili() {
   		List<Testo> testi = testiService.getTesti();
   		testi.removeIf((Testo n) -> n.getFlag_Prestito() == 1);//Lambda expression che rimuove gli elementi dalla lista che rispettano la condizione
   		//Collections.sort(testi, (a, b) -> {return a.getTitolo().compareTo(b.getTitolo());});//Lambda expression che ordina una lista in base alla definizione data del compareTo; a e b sono i due oggetti della lista che vengono confrontati man mano
   		if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@RequestMapping(value = "/listTestiInPrestito", method = RequestMethod.GET)
   	public ResponseEntity<List<Testo>> listTestiInPrestito() {
   		List<Testo> testi = testiService.getTesti();
   		testi.removeIf((Testo n) -> n.getFlag_Prestito() == 0);//Lambda expression che rimuove gli elementi dalla lista che rispettano la condizione
   		//Collections.sort(testi, (a, b) -> {return a.getTitolo().compareTo(b.getTitolo());});//Lambda expression che ordina una lista in base alla definizione data del compareTo; a e b sono i due oggetti della lista che vengono confrontati man mano
   		if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/listTestiByAutoreTitolo", method = RequestMethod.POST)
	public ResponseEntity<List<Testo>> listTestiByAutoreTitolo(@RequestBody Parametro parametro) {
   		List<Testo> testi = testiService.getTesti();
   		String autore  = parametro.getParametroRicerca().trim();
   		String titolo = parametro.getParametroRicerca1().trim();
   		   if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		   
   		if(autore.isEmpty() && titolo.isEmpty())
		   return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);
   		   else if(!autore.isEmpty() && titolo.isEmpty()){
   			   testi.removeIf((Testo n) -> n.getLibro() == null);
   			   testi.removeIf((Testo n) -> !n.getLibro().getAutore().equalsIgnoreCase(autore));
   		   }
	   		   else if(autore.isEmpty() && !titolo.isEmpty()) {
	   			testi.removeIf((Testo n) -> (!n.getTitolo().equalsIgnoreCase(titolo)));
	   		   }
		   		   else {
		   			testi.removeIf((Testo n) -> n.getLibro() == null);
		   			testi.removeIf((Testo n) -> !(n.getTitolo().equalsIgnoreCase(titolo) & n.getLibro().getAutore().equalsIgnoreCase(autore)));
		   		   }
   		   
   		//testi.removeIf((Testo n) -> ((!n.getTitolo().equalsIgnoreCase(autore) && n.getLibro() == null) || (!n.getTitolo().equalsIgnoreCase(autore) && !n.getLibro().getAutore().equalsIgnoreCase(autore))));
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/listTestiByCodiceEditore", method = RequestMethod.POST)
	public ResponseEntity<List<Testo>> listTestiByCodiceEditore(@RequestBody Parametro parametro) {
   		List<Testo> testi = testiService.getTesti();
   		String codice  = parametro.getParametroRicerca().trim();
   		String editore  = parametro.getParametroRicerca1().trim();
   		
   		   if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		
   		if(codice.isEmpty() && editore.isEmpty())
 		   return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);
    		   else if(!codice.isEmpty() && editore.isEmpty()){
    			   testi.removeIf((Testo n) -> (!n.getCodice_ISBN().equalsIgnoreCase(codice)));
    		   }
 	   		   else if(codice.isEmpty() && !editore.isEmpty()) {
 	   			testi.removeIf((Testo n) -> (!n.getEditore().equalsIgnoreCase(editore)));
 	   		   }
 		   		   else {
 		   			testi.removeIf((Testo n) -> !((n.getEditore().equalsIgnoreCase(editore)) & n.getCodice_ISBN().equalsIgnoreCase(codice)));
 		   		   }
   		   
   		//testi.removeIf((Testo n) -> (!n.getEditore().equalsIgnoreCase(para) && !n.getCodice_ISBN().equalsIgnoreCase(para)));     
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/listTestiLibri", method = RequestMethod.GET)
	public ResponseEntity<List<Testo>> listTestiLibri() {
   		List<Testo> testi = testiService.getTestiLibri();
   		   if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/listTestiRiviste", method = RequestMethod.GET)
	public ResponseEntity<List<Testo>> listTestiRiviste() {
   		List<Testo> testi = testiService.getTestiRiviste();
   		   if(testi.isEmpty()){
   			return new ResponseEntity<List<Testo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Testo>>(testi, HttpStatus.OK);
   	}
	
	@RequestMapping(value = "/deleteTesto", method = RequestMethod.POST)
    public Result deleteTesto(@RequestBody Parametro parametro) {	
		Result result = new Result();
		if(testiService.deleteTesto(parametro.getParametroRicerca())) {
    		result.setMessaggio("Cancellazione avvenuta con successo!");
    		result.setTipoMessaggio("success");
    	}
    	else {
    		result.setMessaggio("Cancellazione fallita!");
    		result.setTipoMessaggio("error");
    	}
    	return result;
    }
	
	@RequestMapping(value = "/saveTesto", method = RequestMethod.POST, headers = "Accept=application/json")
    public Result saveTesto(@RequestBody TestoDTO testo) {
		Result result = new Result();
		Testo testoDao = new Testo();
		Genere gDao;
		Libro lDao = new Libro();
		gDao = generiService.getGenere(testo.getCodice_genere());
		testoDao.setTestoFromBean(testo, gDao);
		if(testoDao.getTipo() == 'L'){
			lDao.setLibroFromTesto(testoDao, testo.getCollana(), testo.getAutore());
			testoDao.setLibro(lDao);
		}
		
    	if(testiService.saveTesto(testoDao)) {
    		result.setMessaggio("Salvataggio avvenuto con successo!");
    		result.setTipoMessaggio("success");
    	}
    	else {
    		result.setMessaggio("Salvataggio fallito, testo già presente!");
    		result.setTipoMessaggio("error");
    	}
    	return result;
    }
}
