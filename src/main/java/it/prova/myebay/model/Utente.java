package it.prova.myebay.model;

import java.util.Date; 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "creditoResiduo")
	private int creditoResiduo;
	@Column(name = "dateCreated")
	private Date dateCreated;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utenteInserimento")
	private Set<Annuncio> annunci = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utenteAcquirente")
	private Set<Acquisto> acquisti = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private StatoUtente stato = StatoUtente.CREATO;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "ID"))
	private Set<Ruolo> ruoli = new HashSet<>(0);

	public Utente() {
	}
	
	
	
	public Utente(String username, String password, String nome, String cognome) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}



	public Utente(Long id, String username, String password, String nome, String cognome) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Utente(String username, String password, String nome, String cognome, int creditoResiduo) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.creditoResiduo = creditoResiduo;
	}



	public Utente(String username, String password, String nome, String cognome, StatoUtente stato) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.stato = stato;
	}



	public Utente(String username, String nome, String cognome, Date dateCreated) {
		super();
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dateCreated = dateCreated;
	}



	public Utente(String username, String password, String nome, String cognome, int creditoResiduo, Date dateCreated,
			Set<Annuncio> annunci, Set<Acquisto> acquisti, StatoUtente stato, Set<Ruolo> ruoli) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.creditoResiduo = creditoResiduo;
		this.dateCreated = dateCreated;
		this.annunci = annunci;
		this.acquisti = acquisti;
		this.stato = stato;
		this.ruoli = ruoli;
	}

	public Utente(String username, String password, String nome, String cognome, int creditoResiduo, Date dateCreated,
			Set<Annuncio> annunci, StatoUtente stato, Set<Ruolo> ruoli) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.creditoResiduo = creditoResiduo;
		this.dateCreated = dateCreated;
		this.annunci = annunci;
		this.stato = stato;
		this.ruoli = ruoli;
	}



	public Utente(Long id, String username, String password, String nome, String cognome, int creditoResiduo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.creditoResiduo = creditoResiduo;
	}



	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
	

	public Utente(String username, String password, String nome, String cognome, int creditoResiduo, Date dateCreated) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.creditoResiduo = creditoResiduo;
		this.dateCreated = dateCreated;
	}



	public Utente(Long id) {
		super();
		this.id = id;
	}



	public Utente(String username, String password, String nome, String cognome, Date dateCreated) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dateCreated = dateCreated;
	}
	
	public int getCreditoResiduo() {
		return creditoResiduo;
	}



	public Set<Annuncio> getAnnunci() {
		return annunci;
	}



	public Set<Acquisto> getAcquisti() {
		return acquisti;
	}



	public void setCreditoResiduo(int creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}



	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
	}



	public void setAcquisti(Set<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public StatoUtente getStato() {
		return stato;
	}

	public void setStato(StatoUtente stato) {
		this.stato = stato;
	}

	public boolean isAdmin() {
		for (Ruolo ruoloItem : ruoli) {
			if (ruoloItem.getCodice().equals(Ruolo.ROLE_ADMIN))
				return true;
		}
		return false;
	}
	
	public boolean isUser() {
		for (Ruolo ruoloItem : ruoli) {
			if (ruoloItem.getCodice().equals(Ruolo.ROLE_CLASSIC_USER) || ruoloItem.getCodice().equals(Ruolo.ROLE_ADMIN))
				return true;
		}
		return false;
	}

}