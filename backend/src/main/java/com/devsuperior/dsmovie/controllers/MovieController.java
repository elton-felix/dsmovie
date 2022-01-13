package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController // defininto que essa classe é um controlador rest
@RequestMapping(value = "/movies")//mapeando o caminho que responderar esse controlador
public class MovieController {
	
	@Autowired //no sistema deixamos o gerenciador de dependencia instanciar o objeto e não fazemos isso manualmente com o new.
	private MovieService service;
	
	//metodo para retornar uma pagina de filmes
	@GetMapping //configurando que esse metodo irá responder no camindo /movie pelo verbo get do http
	public Page<MovieDTO> findAll(Pageable pageable){ // Pageable dizendo que a resposta será paginada
		return service.findAll(pageable);
	}
	
	@GetMapping(value = "/{id}") //configurando que esse metodo irá responder no camindo especificado,  pelo verbo get do http
	public MovieDTO findById(@PathVariable Long id){ // configuramos que esse id será o do value acima , usamos PathVariable
		return service.findById(id);
	}
}
