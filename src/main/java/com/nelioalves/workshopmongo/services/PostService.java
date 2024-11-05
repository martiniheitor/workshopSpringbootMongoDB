//Classe intermediária entre Resource e Repository, contém a lógica das operações de manipulação de dados dos posts
package com.nelioalves.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFounException;

@Service
public class PostService {
	
	//funçao que permite a conexão com a classe Repository
	@Autowired
	private PostRepository repo;
	
	//Função de requisição dos dados de um post específico
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado!"));
	}
	
	//Função para requisição de consulta de posts por título
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	//Função para requisição de consulta de um post a partir do texto contido ou do intervalo de tempo em que foi postado
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}