package br.com.rfalessandro.contab.dao;

import java.util.List;

import br.com.rfalessandro.contab.model.PedidoModel;

public class PedidoDAO extends BaseDAO<PedidoModel> {

	
	
	
	
	
	public List<PedidoModel> getAll() {
		return entityManager.createNamedQuery("PedidoModel.getAll", PedidoModel.class).getResultList();
	}
	
	
	
}
