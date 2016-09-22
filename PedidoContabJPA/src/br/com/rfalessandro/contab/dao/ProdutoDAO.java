package br.com.rfalessandro.contab.dao;

import java.util.List;

import br.com.rfalessandro.contab.model.ProdutoModel;

public class ProdutoDAO extends BaseDAO<ProdutoModel> {

	
	
	
	
	
	public List<ProdutoModel> getAllByDesc(String desc) {
		return entityManager.createNamedQuery("ProdutoModel.getAllByDesc", ProdutoModel.class).setParameter(1, "%" + desc + "%" ).getResultList();
	}
	
	
	
}
