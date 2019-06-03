package br.edu.unifacisa.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String tipo;
	private int duracao;

	
	
	private OperadoraENUM tipoOperadora;

	private String operadora;
	
	@Column(name = "operadora", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public OperadoraENUM getTipoOperadora() {
		return tipoOperadora;
	}

	public void setTipoOperadora(OperadoraENUM tipoOperador) {
		this.tipoOperadora = tipoOperador;
		this.operadora=tipoOperador.obterOperadora();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	


}
