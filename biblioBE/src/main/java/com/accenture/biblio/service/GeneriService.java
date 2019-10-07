package com.accenture.biblio.service;

import java.util.List;

import com.accenture.biblio.entity.*;

public interface GeneriService {

    public List < Genere > getGeneri();

    public int saveGenere(Genere genere);

    public Genere getGenere(int theId);
    
    public Genere eliminateGenere(Genere genere);

}