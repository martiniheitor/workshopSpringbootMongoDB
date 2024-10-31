//Classe intermediária entre Resource e Repository, contém a lógica das operações de manipulação de dados dos usuários
package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFounException;

@Service
public class UserService {
	
	//funçao que permite a conexão com a classe Repository
	@Autowired
	private UserRepository repo;
	
	
	//Função de requisição dos dados dos usuários
	public List<User> findAll(){
		return repo.findAll();
	}
	
	//Função d erequisição dos dados de um usuário específico
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado!"));
	}

}
