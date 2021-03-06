package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.dao.AcquistoDAO;
import it.prova.myebay.dao.AnnuncioDAO;
import it.prova.myebay.dao.CategoriaDAO;
import it.prova.myebay.dao.UtenteDAO;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;

public interface AnnuncioService {
	public List<Annuncio> listAll() throws Exception;

	public Annuncio caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Annuncio annuncioInstance) throws Exception;

	public void inserisciNuovo(Annuncio annuncioInstance) throws Exception;

	public void rimuovi(Annuncio annuncioInstance) throws Exception;
	
	public List<Annuncio> findByExample(Annuncio example) throws Exception;
	
	public void inserisciAnnuncioConCategoria(Annuncio example, String[] categorieInstance) throws Exception;
	
	public List<Annuncio> findByExampleEager(Annuncio example) throws Exception;
	
	public Annuncio caricaSingoloElementoEager(Long id) throws Exception;
	
	// per injection
	public void setAnnuncioDAO(AnnuncioDAO annuncioDAO);

	public void setCategoriaDAO(CategoriaDAO categoriaDAO);

	public void rimuovi(Long idAnnuncioToRemove) throws Exception;

	public void acquista(String id, Utente utenteInstance) throws Exception;

	public void setUtenteDAO(UtenteDAO utenteDAO);

	public void setAcquistoDAO(AcquistoDAO acquistoDAO);

	public List<Annuncio> findByExampleEager(Annuncio example, String[] categorie) throws Exception;
	
	
}