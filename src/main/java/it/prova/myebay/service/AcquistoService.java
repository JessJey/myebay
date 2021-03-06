package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.dao.AcquistoDAO;
import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Annuncio;

public interface AcquistoService {
	public List<Acquisto> listAll() throws Exception;

	public Acquisto caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Acquisto acquistoInstance) throws Exception;

	public void inserisciNuovo(Acquisto acquistoInstance) throws Exception;

	public void rimuovi(Acquisto acquistoInstance) throws Exception;
	
	
	
	// per injection
	public void setAcquistoDAO(AcquistoDAO acquistoDAO);

	public List<Acquisto> findByExampleEager(Acquisto example) throws Exception;
}