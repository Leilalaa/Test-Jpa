package bank;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE") 
@Table(name="OPERATION") 
public class Operation {
	
	@Id
	private int id;
	@Column(name = "DATE")
	protected LocalDateTime date;
	@Column(name = "MONTANT")
	protected double montant;
	@Column(name = "MOTIF")
	protected String motif;
	@ManyToOne
	@JoinColumn(name="ID_OP")
	private Compte compte;
	
	public Operation() {

	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}


}
