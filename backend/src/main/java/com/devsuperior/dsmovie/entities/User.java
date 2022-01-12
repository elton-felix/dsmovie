package com.devsuperior.dsmovie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definindo que essa classe é uma entidade
@Table(name = "tb_user") //definindo o nome da tabela no banco de dados
public class User {
	
	@Id //definindo que esse id será o id no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)//definindo que o id é auto incrementavel
	private Long id;
	private String email;
	
	public User() {}

	public User(Long id, String email) {
		this.id = id;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
