package bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bank.Client;
import bank.Compte;
import bank.Operation;
import bank.Banque;

/** .
 *  Cette classe contient le main et permet de gérer notre banque.  
 */

public class Gestionnaire {
	


	public static void main(String[] args) {
		
		/** .
		 *   On commence tout d'abord par créer une Banque, ainsi que plusieurs comptes 
		 */
		Banque b = new Banque();
		b.setId(1);
		b.setNom("Société générale");
		
		LivretA la = new LivretA();
		Compte cc = new Compte();
		
		la.setId(2);
		la.setNumero("13165");
		la.setSolde(18000);
		la.setTaux(1.5);
		
		cc.setId(1);
		cc.setNumero("15315215");
		cc.setSolde(123000);
		
		Virement o = new Virement();
		o.setDate(LocalDateTime.of(2018, 1, 1, 12, 0, 0));
		o.setMontant(13);
		o.setBeneficiaire("Marie Robin");
		o.setMotif("anniversaire");
		
		Set<Operation> wow = new HashSet<Operation>();
		wow.add(o);
		cc.setOperations(wow);
		
		
		/** .
		 *  Nous créeons ensuite un client 
		 * Il est également necessaire de lui créer une adresse 
		 */
		Client c = new Client();
		c.setId(1);
		c.setNom("Dupont");
		c.setPrenom("Martin");
		c.setDateNaissance(LocalDate.of(1990, 12, 24));
		Adresse a = new Adresse(01,"rue des tulipes", 44600,"Saint-Nazaire");
		c.setAdresse(a);
		c.setBanque(b);
		Set<Compte> set = new HashSet<Compte>();
		set.add(la);
		set.add(cc);
		c.setComptes(set);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque"); 
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// Ouverture d'une transaction 
		
		EntityTransaction et = em.getTransaction(); 
		et.begin();

		// Ajout des instances créées à notre base de données Banque
		
		em.persist(b);
		em.persist(o);
		em.persist(cc);
		em.persist(la);
		em.persist(c);
		
		et.commit();
		em.close();
		entityManagerFactory.close();;


	}

}