package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//configurando essa interface para ter operações no banco de dados , como deletar e etc..
	//trocamos de class para interface e extendemos a interface Jpa e passamos o tipo da entidade e o tipo do Id
	
	
	User findByEmail(String email);//findByEmail ja é um metodo do spring dara JPA para criar uma busca com o proprio nome do campo  
}
