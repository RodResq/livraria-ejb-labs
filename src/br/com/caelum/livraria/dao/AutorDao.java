package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;


@Stateless
public class AutorDao {

	@Inject
	private Banco banco;
	
	@PostConstruct
	void aposCriacao() {
	    System.out.println("AutorDao foi criado");
	}

	public void salva(Autor autor) {
		
		System.out.println("Salvando um autor...");
		
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Autor salvo " + autor.getNome());
		banco.save(autor);
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
