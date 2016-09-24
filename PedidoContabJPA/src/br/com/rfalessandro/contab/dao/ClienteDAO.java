package br.com.rfalessandro.contab.dao;

import java.util.List;

import javax.enterprise.context.Dependent;

import br.com.rfalessandro.contab.model.ClienteModel;

@Dependent
public class ClienteDAO extends BaseDAO<ClienteModel> {

	
	
	
	
	
	public List<ClienteModel> getAllByName(String nome) {
		return entityManager.createNamedQuery("ClienteModel.getAllByNome", ClienteModel.class).setParameter(1, "%" + nome + "%" ).getResultList();
	}
	
	
	
}
