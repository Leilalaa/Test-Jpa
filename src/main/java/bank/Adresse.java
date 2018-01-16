package bank;

import javax.persistence.Embeddable;

/** .
 *  Ici, nous definissons une classe adresse qui est de type embeddable.  
 *  Ainsi, nous pouvons faire un lien avec la classe client, et faire en sorte d'avoir une seule table
 */

@Embeddable
public class Adresse {
	
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	
	public Adresse(int numero, String rue, int codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

}
