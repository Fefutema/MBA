package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.core.ForumHelper;
import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("aula3");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		ForumHelper fHelper = new ForumHelper(em);
		
		Forum forum = new Forum();
		forum.setAssunto("Java Persistence");
		forum.setDescricao("Discussão JPA");
		
		System.out.println(fHelper.salvar(forum));
		
		Usuario usuario = new Usuario();
		usuario.setNome("Paulo");
		usuario.setEmail("paulo@p.com");
		
		fHelper.adicionarUsuario(forum.getId(), usuario);
		
	}

}
