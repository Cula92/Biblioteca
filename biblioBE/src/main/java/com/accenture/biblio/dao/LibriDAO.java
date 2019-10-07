package com.accenture.biblio.dao;

import com.accenture.biblio.entity.Libro;

public interface LibriDAO {
	
	public int saveLibro(Libro libro);

	public Libro getLibro(String id);
}
