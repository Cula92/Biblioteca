package com.accenture.biblio.service;

import com.accenture.biblio.entity.Libro;

public interface LibriService {
	
	public int saveLibro(Libro libro);
	
	public Libro getLibro(String id);
}
