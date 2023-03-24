package br.com.fiap.pbecd.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name= "t_pbecd_drone")
public class Drone {

	@Id
	@SequenceGenerator(name="drone", sequenceName="sq_t_pbecd_drone", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drone")
	@Column(name="id_drone")
	private int id;
	
	@Column(name="nr_serie")
	private int numeroSerie;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dataCadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_manutencao")
	private Date dataManutencao;
	
	@Column(name="st_drone")
	private String statusDrone;
	
	@OneToMany(mappedBy = "drone")
	private List<Cliente> clientes;
	
	@OneToMany(mappedBy = "drone")
	private List<Entrega> entregas;
	
	public Drone() {
		super();
	}

	public Drone(int id, int numeroSerie, Date dataCadastro, Date dataManutencao, String statusDrone,
			List<Cliente> clientes, List<Entrega> entregas) {
		super();
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.dataCadastro = dataCadastro;
		this.dataManutencao = dataManutencao;
		this.statusDrone = statusDrone;
		this.clientes = clientes;
		this.entregas = entregas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getStatusDrone() {
		return statusDrone;
	}

	public void setStatusDrone(String statusDrone) {
		this.statusDrone = statusDrone;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
}
