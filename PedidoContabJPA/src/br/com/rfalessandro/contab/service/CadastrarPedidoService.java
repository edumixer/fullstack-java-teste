package br.com.rfalessandro.contab.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.rfalessandro.contab.dao.BaseDAO;
import br.com.rfalessandro.contab.dao.ClienteDAO;
import br.com.rfalessandro.contab.dao.PedidoDAO;
import br.com.rfalessandro.contab.model.PedidoModel;
import br.com.rfalessandro.contab.model.PedidoProdutoModel;


@Dependent
public class  CadastrarPedidoService {

	
	@Inject
	private PedidoDAO pedidoDAO;
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private BaseDAO<PedidoProdutoModel> pedidoProdutoDAO;
	
	
	
	@Transactional(value=TxType.REQUIRED)	
	public PedidoModel cadastrarPedido(PedidoModel pedido) throws Exception
	{
		List<PedidoProdutoModel> lsProduto = pedido.getLsProdutos();
		if(lsProduto == null && lsProduto.size() <= 0) {
			throw new Exception(" O pedido deve conter pelo menos um produto ");
		}
		pedido = pedidoDAO.salvar(pedido);
			
		
		return pedido;
	}
		
	
	
}
