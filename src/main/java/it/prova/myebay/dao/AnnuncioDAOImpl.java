package it.prova.myebay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.myebay.model.Annuncio;

public class AnnuncioDAOImpl implements AnnuncioDAO {
	private EntityManager entityManager;

	@Override
	public List<Annuncio> list() throws Exception {
		return entityManager.createQuery("from Annuncio", Annuncio.class).getResultList();
	}

	@Override
	public Optional<Annuncio> findOne(Long id) throws Exception {
		Annuncio result = entityManager.find(Annuncio.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Annuncio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Annuncio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Annuncio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Annuncio> findByExample(Annuncio example) throws Exception {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select distinct a from Annuncio a join fetch a.utenteInserimento u join a.categorie c  where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getTestoAnnuncio())) {
			whereClauses.add(" a.testoAnnuncio  like :testoAnnuncio ");
			paramaterMap.put("testoAnnuncio", "%" + example.getTestoAnnuncio() + "%");
		}
		if (example.getPrezzo() != null) {
			whereClauses.add("a.prezzo >= :prezzo ");
			paramaterMap.put("prezzo", example.getPrezzo());
		}
		if(example.getCategorie() != null && !example.getCategorie().isEmpty()) {
			whereClauses.add("c in :listaCategorie ");
			paramaterMap.put("listaCategorie", example.getCategorie());
		}
		
		whereClauses.add("a.aperto = true ");
		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Annuncio> typedQuery = entityManager.createQuery(queryBuilder.toString(), Annuncio.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

	@Override
	public List<Annuncio> findByExampleEager(Annuncio example) throws Exception {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder(
				"select a from Annuncio a join a.utenteInserimento u where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getTestoAnnuncio())) {
			whereClauses.add(" a.testoAnnuncio  like :testoAnnuncio ");
			paramaterMap.put("testoAnnuncio", "%" + example.getTestoAnnuncio() + "%");
		}
		if (example.getPrezzo() != null) {
			whereClauses.add("a.prezzo >= :prezzo ");
			paramaterMap.put("prezzo", example.getPrezzo());
		}
		if (example.getData() != null) {
			whereClauses.add("a.data >= :data ");
			paramaterMap.put("data", example.getData());
		}
		if (example.getUtenteInserimento().getId() != null) {
			whereClauses.add("u.id = :idUtente ");
			paramaterMap.put("idUtente", example.getUtenteInserimento().getId());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Annuncio> typedQuery = entityManager.createQuery(queryBuilder.toString(), Annuncio.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

	@Override
	public Optional<Annuncio> findOneEager(Long id) throws Exception {

		return entityManager
				.createQuery("from Annuncio a left join fetch a.categorie c where a.id=:idAnnuncio", Annuncio.class)
				.setParameter("idAnnuncio", id).getResultList().stream().findFirst();
	}
	
	@Override
	public List<Annuncio> findByExampleEager(Annuncio example, String[] categorie) throws Exception {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();
		String categ = "";

		StringBuilder queryBuilder = new StringBuilder("select distinct a from Annuncio a join fetch a.utenteInserimento u join a.categorie c where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getTestoAnnuncio())) {
			whereClauses.add(" a.testoAnnuncio  like :testoAnnuncio ");
			paramaterMap.put("testoAnnuncio", "%" + example.getTestoAnnuncio() + "%");
		}

		if (example.getPrezzo() > 0) {
			whereClauses.add(" a.prezzo >= :prezzo ");
			paramaterMap.put("prezzo", example.getPrezzo());
		}


		if (example.isAperto()) {
			whereClauses.add("a.aperto like :aperto ");
			paramaterMap.put("aperto", true);
		}
		
		if(categorie != null && categorie.length > 0) {
			for (int i = 0; i < categorie.length; i++) {
				if(i == 0)
					categ += " c.id = " + categorie[i];
				else
					categ += " or c.id = " + categorie[i];
			}
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		if(categorie != null)
			queryBuilder.append(" and " + categ);
		TypedQuery<Annuncio> typedQuery = entityManager.createQuery(queryBuilder.toString(), Annuncio.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}
}
