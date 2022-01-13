package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;

@RestController // defininto que essa classe é um controlador rest
@RequestMapping(value = "/scores")//mapeando o caminho que responderar esse controlador
public class ScoreController {
	
	@Autowired//no sistema deixamos o gerenciador de dependencia instanciar o objeto e não fazemos isso manualmente com o new.
	private ScoreService service;
	
	@PutMapping//configurando que esse metodo será do verbo http put(salvar de forma idenpotente) , se salvarmos mais de uma vez com o mesmo email , vai ser da mesma forma que tivesse salvo uma vez
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){ //metodo salva um score que o corpo da requisição é o scoreDTO
		//configuramos que o corpo da requisição vai ser pego do Json e convertido para scoreDTO , usamos requestboy
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
}
