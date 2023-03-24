package br.com.fiap.pbecd.test;

import br.com.fiap.pbecd.entities.ContatoCliente;
import br.com.fiap.pbecd.entities.Receita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteRemover {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("pbecd");
		EntityManager em = fabrica.createEntityManager();
		
		//Remover
		ContatoCliente contatoCliente = em.find(ContatoCliente.class, 1);
		em.remove(contatoCliente);
		
		Receita receita = em.find(Receita.class, 1);
		em.remove(receita);
		
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		em.close();
		fabrica.close();

	}

}
