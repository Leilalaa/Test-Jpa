package bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Client;
import entity.Emprunt;
import entity.Livre;

public class Gestionnaire {
	


	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque"); 
		EntityManager em = entityManagerFactory.createEntityManager();

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

		
		em.close();
		entityManagerFactory.close();;


	}

}