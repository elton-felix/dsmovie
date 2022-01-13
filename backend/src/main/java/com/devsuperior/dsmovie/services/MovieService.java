package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

//classe reponsavel pela transação de buscar os filmes

@Service //registra que o movieService é um componete do sistema , é necessario quando é uma classe customizada
public class MovieService {
	
	@Autowired //no sistema deixamos o gerenciador de dependencia instanciar o objeto e não fazemos isso manualmente com o new.
	private MovieRepository repository;
	
	//metodo responsavel por buscar os filmes
	@Transactional(readOnly = true) //a tag fala configura que esse metodo resolvera tudo de transação , o readOnly fala que esse metodo é só de leitura , tornando mais eficiente no BD
	public Page<MovieDTO> findAll(Pageable pageable) { //pageable objeto especial para paginação
		Page<Movie> result = repository.findAll(pageable); //buscando os filmes no banco
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x)); //map aplica uma função a cada elemento da lista, pra cada elemento(x) , converte para DTO
		return page;
	}
	
	//metodo responsavel por buscar um filme
		@Transactional(readOnly = true) //a tag fala configura que esse metodo resolvera tudo de transação , o readOnly fala que esse metodo é só de leitura , tornando mais eficiente no BD
		public MovieDTO findById(Long id) { //pageable objeto especial para paginação
			Movie result = repository.findById(id).get(); //buscando o filme pelo id , o ById retorna um objeto optional por padrão , precisando do .get para retornar o id dentro do optional
			MovieDTO dto = new MovieDTO(result); // convertendo oq é Movie para o dto
			return dto;
		}
}
