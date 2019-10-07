package com.accenture.biblio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.biblio.common.beans.*;
import com.accenture.biblio.entity.Genere;
import com.accenture.biblio.service.*;

@RestController
@RequestMapping("/genere")
public class GeneriController {

    @Autowired
    private GeneriService generiService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
   	public ResponseEntity<List<Genere>> listAllGeneri() {
   		List<Genere> generi = generiService.getGeneri();
   		if(generi.isEmpty()){
   			return new ResponseEntity<List<Genere>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
   		}
   		return new ResponseEntity<List<Genere>>(generi, HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/saveGenere", method = RequestMethod.POST, headers = "Accept=application/json")
    public int saveGenere(@RequestBody Genere genere) {	
    	return generiService.saveGenere(genere);	
    }
    
    @RequestMapping(value = "/getGenere", method = RequestMethod.POST)
    public Genere getGenereById(HttpServletRequest request) {
    	//System.out.print(param.get("id"));
    	Genere genere = generiService.getGenere(1);
        return genere;	
    }
    
    @RequestMapping(value="/eliminateGenere", method = RequestMethod.POST)
    public void eliminateGenere(@RequestBody Genere genere) {	
    	generiService.eliminateGenere(genere);	
    }
}