package com.devsuperior.dsmovie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //definindo que essa classe é uma entidade
@Table(name = "tb_movie") //definindo o nome da tabela no banco de dados
public class Movie {
	
	@Id //definindo que esse id será o id no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)//definindo que o id é auto incrementavel
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	//fazendo referencia para todos os scores do movie
	//usamos o set para garantir que não temos dados repetidos, no muito pra muitos
	@OneToMany(mappedBy = "id.movie") // configurando que a relação das entidades é 1 para muitos
	private Set<Score> scores = new HashSet<>(); //hashset pois o Set é uma interface, então instanciamos uma classe que implemente uma interface
	
	public Movie() {
	}

	public Movie(Long id, String title, Double score, Integer count, String image) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Score> getScores() {
		return scores;
	}
	
	
	
	
	
}
