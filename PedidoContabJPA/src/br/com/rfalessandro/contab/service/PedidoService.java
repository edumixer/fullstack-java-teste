package br.com.rfalessandro.contab.service;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.rfalessandro.contab.dao.PedidoDAO;
import br.com.rfalessandro.contab.model.PedidoModel;



@Dependent
public class  PedidoService {

	
	@Inject
	private PedidoDAO pedidoDAO;
	
	
	
	public List<PedidoModel> buscarPedidos(BigDecimal codigo)
	{		
		return pedidoDAO.getAllByCodigo(codigo);
	}
	
	@Transactional(value=TxType.REQUIRED)
	public  void cadastarPedido(PedidoModel pedido) throws Exception {
		pedidoDAO.salvar(pedido);
	}

	public PedidoModel buscarPedido(Long cdPedido) {
		return pedidoDAO.getByCdPedido(cdPedido);
	}
	
}
