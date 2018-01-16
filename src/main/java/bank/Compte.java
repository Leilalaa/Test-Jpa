package bank;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@MappedSuperclass 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Table(name="COMPTE") 

public class Compte {

	@Id
	private int id;
	@Column(name = "NUMERO")
	protected String numero;
	@Column(name = "SOLDE")
	protected double solde;
	
	@ManyToMany
	@JoinTable(name="CLIENT_COMPTE",
			joinColumns= @JoinColumn(name="ID_BAN", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID")
			)
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	public Compte() {
		clients = new HashSet<Client>();
		operations = new HashSet<Operation>();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}
