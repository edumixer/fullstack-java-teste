package br.com.rfalessandro.contab.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rfalessandro.contab.model.BaseModel;

@Dependent
public class BaseDAO<T extends BaseModel> {

	@PersistenceContext(unitName = "PedidoContabPU")
	protected EntityManager entityManager;

	// Classe utilizada para adicionar todos métodos comuns a todos os DAOS

	
	public T salvar(T model) {
		return entityManager.merge(model);
	}

	
	public void remover(T model) {
		entityManager.remove(model);
	}
	
	
	
	
}
