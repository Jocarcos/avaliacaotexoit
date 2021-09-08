package com.vencedorpiorfilme.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="Tb_Vencedor")
public class VencedorPiorFilme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Você deve informar o ano")
	@Min(value = 1800, message = "Você deve informar uma valor maior que 1800")
	private Integer year;
	
	@NotEmpty(message = "Você deve informar o Título")
	private String title;
	
	@NotEmpty(message = "Você deve informar o Studio")
	private String studios;
	
	@NotEmpty(message = "Você deve informar o Produtor")
	private String producers;
	
	private String winner;
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStudios() {
		return studios;
	}
	
	public void setStudios(String studios) {
		this.studios = studios;
	}
	
	public String getProducers() {
		return producers;
	}
	
	public void setProducers(String producers) {
		this.producers = producers;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}
