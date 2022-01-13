package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

//classe reponsavel pela transação de buscar os filmes

@Service //registra que o movieService é um componete do sistema , é necessario quando é uma classe customizada
public class ScoreService {
	
	@Autowired //no sistema deixamos o gerenciador de dependencia instanciar o objeto e não fazemos isso manualmente com o new.
	private MovieRepository movieRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private ScoreRepository scoreRepository;
	
	//metodo para salvar o score no banco de dados
	@Transactional // garante a transação com o banco
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());//buscando no banco o usuario pelo email e guardando no user
		if (user == null) { //verificando se o usuario é inexistente
			user = new User();//instanciando um novo usuario
			user.setEmail(dto.getEmail());//setando o email
			user = userRepository.saveAndFlush(user); //salva no banco de dados e retorna uma refencia desse usuario atualizada
			//and flush garante que temos o objeto atualizado
		}
		
		//buscando o filme no banco
		Movie movie = movieRepository.findById(dto.getMovieId()).get(); //ById por padrão retorna um objeto optional , ultilizamos o get para pegar o objeto dentro do optional
		
		Score score = new Score(); 
		score.setMovie(movie);//colocando a referencia do movie
		score.setUser(user);//colocando a referencia do user
		score.setValue(dto.getScore());//colocando a referencia do score
		
		//salvando no banco
		score = scoreRepository.saveAndFlush(score); //andflush para garantir o salvamento e retornar os resultados
		
		//percorrendo a lista de scores, somando e atribuindo a variavel sum
		double sum = 0.0;
		for(Score s: movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		//calculando a nova media do filme
		double avg = sum / movie.getScores().size();
		
		//salvando a nova media e nova contagem
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		//salvando o movie
		movie = movieRepository.save(movie);
		
		
		return new MovieDTO(movie);//retornando o movie convertido para dto
	}
}
