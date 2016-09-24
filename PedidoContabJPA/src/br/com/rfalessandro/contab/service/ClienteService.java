package br.com.rfalessandro.contab.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.rfalessandro.contab.dao.ClienteDAO;
import br.com.rfalessandro.contab.model.ClienteModel;


@Dependent
public class ClienteService {

	
	@Inject
	private ClienteDAO clienteDAO;
	
	
	public List<ClienteModel> buscarClientes(String nome)
	{
		if(nome == null) {
			nome = "";
		}
		return clienteDAO.getAllByName(nome);
	}
	
	
	@Transactional(value=TxType.REQUIRED)
	public void cadastarCliente(ClienteModel cliente) throws Exception {
		clienteDAO.salvar(cliente);
	}
	
}
