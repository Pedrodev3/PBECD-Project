package br.com.fiap.pbecd.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name= "t_pbecd_cliente")
public class Cliente {

	@Id
	@SequenceGenerator(name="cliente", sequenceName="sq_t_pbecd_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name="id_cliente")
	private int id;
	
	@Column(name="nm_cliente")
	private String nomeCliente;
	
	@Column(name="nr_cpf")
	private int cpf;
	
	@Column(name="nm_rg")
	private String rg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dataNascimento;
	
	@Column(name="fl_sexo_biologico")
	private String sexoBiologico;
	
	@Column(name="nm_grupo_sanguineo")
	private String grupoSanguineo;
	
	@ManyToOne
	@JoinColumn(name="id_drone")
	private Drone drone;
	
	// Relacionamento 1:N
	@OneToMany(mappedBy = "cliente")
	private List<ContatoCliente> contatos;
	
	@OneToMany(mappedBy = "cliente")
	private List<EnderecoCliente> endereco;
	
	@OneToMany(mappedBy = "cliente")
	private List<Receita> receitas;
	
	@OneToMany(mappedBy = "cliente")
	private List<Entrega> entregas;
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nomeCliente, int cpf, String rg, Date dataNascimento, String sexoBiologico,
			String grupoSanguineo, Drone drone, List<ContatoCliente> contatos, List<EnderecoCliente> endereco,
			List<Receita> receitas, List<Entrega> entregas) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexoBiologico = sexoBiologico;
		this.grupoSanguineo = grupoSanguineo;
		this.drone = drone;
		this.contatos = contatos;
		this.endereco = endereco;
		this.receitas = receitas;
		this.entregas = entregas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexoBiologico() {
		return sexoBiologico;
	}

	public void setSexoBiologico(String sexoBiologico) {
		this.sexoBiologico = sexoBiologico;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public List<ContatoCliente> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoCliente> contatos) {
		this.contatos = contatos;
	}

	public List<EnderecoCliente> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoCliente> endereco) {
		this.endereco = endereco;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}	
	
}
