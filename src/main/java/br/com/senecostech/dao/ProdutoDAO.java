package br.com.senecostech.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.senecostech.model.Produto;

public class ProdutoDAO {
	private EntityManager em;
	private String jpql;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Produto>getProdutos(){
		jpql = "SELECT p from Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public void editaProdutoPeloId(Produto produto) {
		em.merge(produto);
		
	}
	
//	public Produto listaProdutoPeloId (Integer id) {
//		jpql ="SELECT p from Produto p WHERE p.ID = :id";
//		
//		return em.createQuery(jpql, Produto.class)
//				.setParameter(0, id)
//				.getSingleResult();
//		
//		
//	}
	
	public Produto listaProdutoPeloId(Integer id) {
		return em.find(Produto.class, id);
	}
	
	public void cadastraProdutoNovo (Produto produto) {
		 this.em.persist(produto);
	}
	
	public void removeProdutoPeloId (Integer id) {
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);
	}
	
	

}
