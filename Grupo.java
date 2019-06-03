package br.edu.unifacisa.bd;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "grupo")
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_grupo")
	private Long id;
	private String nome;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="grupos_contatos",
	joinColumns=@JoinColumn(name="id_grupo"),
	inverseJoinColumns=@JoinColumn(name="contato_id"))
	@JoinColumn(name = "id_grupo")
	private List<Contato> contatos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
	
	

}
