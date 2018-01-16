package bank;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/** .
 *  Ici, nous definissons les clients de la banque 
 *  afin d'ensuite créer la table Client dans la base de données banque
 */


@Entity 
@Table(name="CLIENT") 

public class Client {
	
	@Id 
	private Integer id;
	@Column(name = "NOM", length = 50, nullable = false) 
	private String nom;
	@Column(name = "PRENOM", length = 50, nullable = false) 
	private String prenom;
	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;
	@Embedded
	@Column(name = "ADRESSE")
	private Adresse adresse;
	
	@ManyToMany
	@JoinTable(name="CLIENT_COMPTE",
	joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_BAN", referencedColumnName="ID")
	)
	private Set<Compte> comptes;
	
	@ManyToOne
	@JoinColumn(name="ID_CLI")
	private Banque banque;
	
	public Client() {
		comptes = new HashSet<Compte>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	
	// Methode toString redefinie ici afin de pouvoir afficher les informations d'un client
	
	public String toString(){
		
		String s = "ID : "+this.getId()+", Nom : "+this.getNom()+", Prenom : "+this.getPrenom()+", Date de naissance : "+this.getDateNaissance();
		return s;
	}

}
