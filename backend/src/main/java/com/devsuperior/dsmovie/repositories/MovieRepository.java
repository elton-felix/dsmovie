package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	//configurando essa interface para ter operações no banco de dados , como deletar e etc..
	//trocamos de class para interface e extendemos a interface Jpa e passamos o tipo da entidade e o tipo do Id
	
}
