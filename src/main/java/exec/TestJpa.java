package exec;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Client;
import entity.Emprunt;
import entity.Livre;

public class TestJpa {
	


	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai"); 
		EntityManager em = entityManagerFactory.createEntityManager();
		
	// Chercher un livre en particulier
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez entrer le titre du livre recherch� :");
		
		String titleSearch = sc.next();
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre=:titre", Livre.class);
		query.setParameter("titre", titleSearch);
		Livre l = (Livre) query.getResultList().get(0);
		System.out.println(l.toString());

////////////////////////////////////////////////////////////////////////////////////


		
		TypedQuery<Emprunt> query2 = em.createQuery("select e from Emprunt e where e.id=3", Emprunt.class);
		
		Emprunt e = (Emprunt) query2.getResultList().get(0);
		
		for (Livre l2 : e.getLivres()){
			
			System.out.println(l2.toString());
			
		}
		
////////////////////////////////////////////////////////////////////////////////////
		
		//TypedQuery<Client> query3 = em.createQuery("select e from Client e where e.id=1", Client.class);
		
		//Client c = (Client) query3.getResultList().get(0);
		
		Client c = em.find(Client.class, 1);
		
		for (Emprunt e2 : c.getEmprunts()){
			
			System.out.println(e2.toString());
			
		}

		sc.close();
		em.close();
		entityManagerFactory.close();;


	}

}
