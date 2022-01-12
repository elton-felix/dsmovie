package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //definindo que essa classe é uma entidade
@Table(name = "tb_score") //definindo o nome da tabela no banco de dados
public class Score {
	
	@EmbeddedId //definindo que o id é composto
	private ScorePK id = new ScorePK(); //no java quando criamos uma chave primaria composta , damos o new para garantimos que ela vai ser instanciada
	
	private Double value;
	
	public Score() {
		
	}
	
	public void setMovie(Movie movie) {//ultilizando esse metodo para quando informarmos um filme , associarmos com o score
		id.setMovie(movie);
	}
	
	public void setUser(User user) {//ultilizando esse metodo para quando informarmos um usuario , associarmos com o score
		id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
