package br.com.rfalessandro.contab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rfalessandro.contab.model.BaseModel;


public class BaseDAO<T extends BaseModel> {

	@PersistenceContext(unitName = "PedidoContabPU")
	protected EntityManager entityManager;

	// Classe utilizada para adicionar todos métodos comuns a todos os DAOS

	
	public void salvar(T model) {
		entityManager.persist(model);
	}

	
	public void remover(T model) {
		entityManager.remove(model);
	}
	
	
	

	public T editar(T model) {
		return entityManager.merge(model);
	}
}
