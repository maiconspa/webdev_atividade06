package model;

import java.io.Serializable;

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private Long populacao;
	private Double area;
	
	
	public Pais() {}
	
	public Pais(int id)  {
		this.id = id;
	}
	
	public Pais(int id, String nome, Long populacao, Double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	// GETTERS
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public Double getArea() {
		return area;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return 	"ID: " + getId() +
				"Nome: " + getNome() +
				"   Populacao: " + getPopulacao() +
				"   Area: " + getArea();
	}
}
