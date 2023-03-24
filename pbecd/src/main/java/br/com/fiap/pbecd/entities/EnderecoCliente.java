package br.com.fiap.pbecd.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "t_pbecd_endereco_cliente")
public class EnderecoCliente {

	@Id
	@SequenceGenerator(name = "endereco_cliente", sequenceName = "sq_t_pbecd_endereco_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_cliente")
	@Column(name = "id_endereco")
	private int id;

	@Column(name = "nr_logradouro")
	private int numeroLogradouro;

	@Column(name = "ds_complemento_numero")
	private String dsComplementoNumero;

	@Column(name = "ds_ponto_referencia")
	private String dsPontoReferencia;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim")
	private Date dataFim;

	// Relacionamento N : 1
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public EnderecoCliente() {
		super();
	}

	public EnderecoCliente(int id, int numeroLogradouro, String dsComplementoNumero, String dsPontoReferencia,
			Date dataInicio, Date dataFim, Cliente cliente) {
		super();
		this.id = id;
		this.numeroLogradouro = numeroLogradouro;
		this.dsComplementoNumero = dsComplementoNumero;
		this.dsPontoReferencia = dsPontoReferencia;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getDsComplementoNumero() {
		return dsComplementoNumero;
	}

	public void setDsComplementoNumero(String dsComplementoNumero) {
		this.dsComplementoNumero = dsComplementoNumero;
	}

	public String getDsPontoReferencia() {
		return dsPontoReferencia;
	}

	public void setDsPontoReferencia(String dsPontoReferencia) {
		this.dsPontoReferencia = dsPontoReferencia;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
