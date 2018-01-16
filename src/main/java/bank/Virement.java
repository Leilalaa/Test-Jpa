package bank;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="VIREMENT") 
@DiscriminatorValue("V") 
public class Virement extends Operation {

	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;
	
	public Virement() {

	}

	
	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}


}
