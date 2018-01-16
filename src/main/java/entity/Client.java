package entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** .
 *  Ici, nous definissons un client de la bibiotheque 
 *  à partir de la table client de notre base de données Bibliotheque
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
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts;
	
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

		// constructeurs 
		public Client() { 
			emprunts = new HashSet<Emprunt>();
		}
	
	// Getters et setters
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
		
		// Methode toString redefinie ici afin de pouvoir afficher un client
		public String toString(){
			
			String s = "ID : "+this.getId()+", Nom : "+this.getNom()+", Prenom : "+this.getPrenom();
			return s;
		}
	
}
