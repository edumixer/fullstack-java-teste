package br.com.rfalessandro.contab.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.rfalessandro.contab.dao.PedidoDAO;
import br.com.rfalessandro.contab.model.PedidoModel;


@Transactional
@Dependent
public class  PedidoService {

	
	@Inject
	private PedidoDAO pedidoDAO;
	
	
	
	public List<PedidoModel> buscarPedidos()
	{		
		return pedidoDAO.getAll();
	}
	
	@Transactional(value=TxType.REQUIRED)
	public  PedidoModel cadastarPedido(PedidoModel pedido) {
		return pedidoDAO.salvar(pedido);
	}
	
}
