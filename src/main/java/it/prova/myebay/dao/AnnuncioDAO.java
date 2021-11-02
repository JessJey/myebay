package it.prova.myebay.dao;

import java.util.List;
import java.util.Optional;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio> {
	public List<Annuncio> findByExample(Annuncio example) throws Exception;

	public List<Annuncio> findByExampleEager(Annuncio example) throws Exception;

	public Optional<Annuncio> findOneEager(Long id) throws Exception;

	public List<Annuncio> findByExampleEager(Annuncio example, String[] categorie) throws Exception;
}
