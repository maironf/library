package com.mairo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mairo.bookstore.domain.Categoria;
import com.mairo.bookstore.repositories.CategoriaRepository;
import com.mairo.bookstore.service.exceptions.ObjectNotFoundException;

//Logicas de negócio ficam aqui
@Service
public class CategoriaService {

	private CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {

		this.repository = repository;
	}

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto Não encontrado! id:"+id+", tipo:"+Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
}