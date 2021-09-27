package com.mairo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mairo.bookstore.domain.Categoria;
import com.mairo.bookstore.domain.Livro;
import com.mairo.bookstore.repositories.LivroRepository;

import com.mairo.bookstore.service.exceptions.ObjectNotFoundException;

//Logicas de negócio ficam aqui
@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto Não encontrado! id:"+id+", tipo:"+Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllbyCategoria(id_cat);
	}
}
