package entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="EMPRUNT") 


public class Emprunt {

	@Id 
	private Integer id;
	@Column(name = "DATE_DEBUT") 
	private LocalDate dateDebut; 
	@Column(name = "DATE_FIN") 
	private LocalDate dateFin;
	@Column(name = "DELAI")
	private int delai;

	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
	joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;

	public Set<Livre> getLivres() {
		return livres;
	}
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
		// constructeurs 
		public Emprunt() { 
			livres = new HashSet<Livre>();
			
		}
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public LocalDate getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(LocalDate dateDebut) {
			this.dateDebut = dateDebut;
		}

		public LocalDate getDateFin() {
			return dateFin;
		}

		public void setDateFin(LocalDate dateFin) {
			this.dateFin = dateFin;
		}

		public int getDelai() {
			return delai;
		}

		public void setDelai(int delai) {
			this.delai = delai;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
		
		public String toString(){
			
			String s = "  "+this.getId()+" "+this.getDateDebut()+"  "+this.getDelai()+" "+this.getDateFin();
			return s;
		}
}
