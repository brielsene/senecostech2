package br.com.senecostech.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.senecostech.model.Produto;
import br.com.senecostech.util.JPAUtil;

public class TesteJPAUtil {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Produto find = em.find(Produto.class, 3);
		System.out.println(find.getNome());
		
		List resultList = em.createQuery("SELECT p from Produto p").getResultList();
		resultList.forEach(System.out::println);

	}

}
