package br.com.fiap.pbecd.test;

import br.com.fiap.pbecd.entities.ContatoCliente;
import br.com.fiap.pbecd.entities.Receita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteInserir {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("pbecd");
		EntityManager em = fabrica.createEntityManager();
		
		ContatoCliente contatoCliente = new ContatoCliente();
		contatoCliente.setNomeContato("Pedro Victor");
		contatoCliente.setNumeroDdi(333);
		contatoCliente.setNumeroDdd(999);
		contatoCliente.setNumeroTelefone(970854236);
		
		Receita receita = new Receita();
		receita.setDsRemedio("Buscopan");
		
		try {
			em.persist(contatoCliente);
			em.persist(receita);
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
