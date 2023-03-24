package br.com.fiap.pbecd.test;

import br.com.fiap.pbecd.entities.ContatoCliente;
import br.com.fiap.pbecd.entities.Receita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteBuscarAtualizar {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("pbecd");
		EntityManager em = fabrica.createEntityManager();
		
		
		// Busca
		ContatoCliente contatoCliente = em.find(ContatoCliente.class, 1);
		System.out.println(contatoCliente.getId() + "" + contatoCliente.getNomeContato());
		
		Receita receita = em.find(Receita.class, 1);
		System.out.println(receita.getId() + "" + receita.getDsRemedio());
		
		// Atualizar
		contatoCliente.setNomeContato("João Pereira");
		receita.setDsRemedio("Paracetamol");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
