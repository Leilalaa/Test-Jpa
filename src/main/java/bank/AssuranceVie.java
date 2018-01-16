package bank;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="ASSURANCEVIE") 

public class AssuranceVie extends Compte {
	
	@Id
	private int id;
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;
	@Column(name = "TAUX")
	private double taux;
	
	public AssuranceVie() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
