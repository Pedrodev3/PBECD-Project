package br.com.fiap.pbecd.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_pbecd_entrega")
public class Entrega {

	@Id
	@SequenceGenerator(name = "entrega", sequenceName = "sq_t_pbecd_entrega", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrega")
	@Column(name = "id_entrega")
	private int id;

	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Column(name = "dt_fim")
	private Date dataFim;

	@Column(name = "st_entrega")
	private String statusEntrega;

	// Relacionamento Muitos para muitos
	@ManyToMany(mappedBy = "entregas")
	private List<Receita> receitas;

	// Relacionamento N : 1
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	// Relacionamento N : 1
	@ManyToOne
	@JoinColumn(name = "id_drone")
	private Drone drone;

	public Entrega() {
		super();
	}

	public Entrega(int id, Date dataInicio, Date dataFim, String statusEntrega, List<Receita> receitas, Cliente cliente,
			Drone drone) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.statusEntrega = statusEntrega;
		this.receitas = receitas;
		this.cliente = cliente;
		this.drone = drone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

}
