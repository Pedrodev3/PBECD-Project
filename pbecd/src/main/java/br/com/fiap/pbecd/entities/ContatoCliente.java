package br.com.fiap.pbecd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "t_pbecd_contato_cliente")
public class ContatoCliente {

	@Id
	@SequenceGenerator(name="contato_cliente", sequenceName="sq_t_pbecd_contato_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_cliente")
	@Column(name="id_contato")
	private int id;
	
	@Column(name="nm_contato")
	private String nomeContato;
	
	@Column(name="nr_ddi")
	private int numeroDdi;
	
	@Column(name="nr_ddd")
	private int numeroDdd;
	
	@Column(name="nr_telefone")
	private int numeroTelefone;
	
	// Relacionamento N : 1
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public ContatoCliente() {
		super();
	}

	public ContatoCliente(int id, String nomeContato, int numeroDdi, int numeroDdd, int numeroTelefone,
			Cliente cliente) {
		super();
		this.id = id;
		this.nomeContato = nomeContato;
		this.numeroDdi = numeroDdi;
		this.numeroDdd = numeroDdd;
		this.numeroTelefone = numeroTelefone;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public int getNumeroDdi() {
		return numeroDdi;
	}

	public void setNumeroDdi(int numeroDdi) {
		this.numeroDdi = numeroDdi;
	}

	public int getNumeroDdd() {
		return numeroDdd;
	}

	public void setNumeroDdd(int numeroDdd) {
		this.numeroDdd = numeroDdd;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
