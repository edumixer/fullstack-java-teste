package br.com.rfalessandro.contab.dao;

import java.util.List;

import br.com.rfalessandro.contab.model.ClienteModel;

public class ClienteDAO extends BaseDAO<ClienteModel> {

	
	
	
	
	
	public List<ClienteModel> getAllByName(String nome) {
		return entityManager.createNamedQuery("ClienteModel.getAllByNome", ClienteModel.class).setParameter(1, "%" + nome + "%" ).getResultList();
	}
	
	
	
}
