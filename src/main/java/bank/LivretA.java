package bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="LIVRETA") 

public class LivretA extends Compte {
	
	@Id
	private int id;
	@Column(name = "TAUX")
	private double taux;
	
	public LivretA() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
