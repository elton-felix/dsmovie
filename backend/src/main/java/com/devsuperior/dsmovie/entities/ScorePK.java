package com.devsuperior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScorePK implements Serializable{
	//o serializable defini que a chave estrangeira ou outros objetos possa ser convertida para bytes , JPA exige que implemente a serializable
	//é importante por causa do trafego em rede , salvado em arquivo e etc...
	
	private static final long serialVersionUID = 1L;//numero de versão

	@ManyToOne //faz a configuração de uma chave estrangeira
	@JoinColumn(name = "movie_id") //definindo o nome da chave estrangeira
	private Movie movie;
	
	@ManyToOne //faz a configuração de uma chave estrangeira
	@JoinColumn(name = "user_id") //definindo o nome da chave estrangeira
	private User user;
	
	public ScorePK() {
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
