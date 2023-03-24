package br.com.fiap.pbecd.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "t_pbecd_receita")
public class Receita {

	@Id
	@SequenceGenerator(name = "receita", sequenceName = "sq_t_pbecd_receita", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receita")
	@Column(name = "id_receita")
	private int id;

	@Column(name = "ds_remedio")
	private String dsRemedio;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	// Relacionamento Muitos para muitos
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "id_receita"), inverseJoinColumns = @JoinColumn(name = "id_entrega"), name = "t_pbecd_entrega_receita")
	private List<Entrega> entregas;

	// Relacionamento N : 1
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Receita() {
		super();
	}

	public Receita(int id, String dsRemedio, Date dataInicio, List<Entrega> entregas, Cliente cliente) {
		super();
		this.id = id;
		this.dsRemedio = dsRemedio;
		this.dataInicio = dataInicio;
		this.entregas = entregas;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDsRemedio() {
		return dsRemedio;
	}

	public void setDsRemedio(String dsRemedio) {
		this.dsRemedio = dsRemedio;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
