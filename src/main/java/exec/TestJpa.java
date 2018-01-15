package exec;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Livre;

public class TestJpa {
	
	public static final Logger LOG = LoggerFactory.getLogger("dev.console");

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai"); 
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// Chercher un livre en particulier
		

		Scanner sc = new Scanner(System.in);
		
		LOG.info("Veuillez entrer le titre du livre recherché :");
		
		String titleSearch = sc.next();
		
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre=:titre", Livre.class);
		
		query.setParameter("titre", titleSearch);
		Livre l = (Livre) query.getResultList().get(0);
		LOG.info(l.toString());


		
		
		em.close();
		entityManagerFactory.close();
		sc.close();


	}

}
