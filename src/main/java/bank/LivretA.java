package bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="LIVRETA") 
public class LivretA extends Compte {

	@Column(name = "TAUX")
	private double taux;
	
	public LivretA() {

	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
