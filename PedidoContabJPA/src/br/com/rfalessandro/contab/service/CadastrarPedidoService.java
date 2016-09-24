package br.com.rfalessandro.contab.service;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.rfalessandro.contab.dao.ClienteDAO;
import br.com.rfalessandro.contab.dao.PedidoDAO;
import br.com.rfalessandro.contab.dao.PedidoProdutoDAO;
import br.com.rfalessandro.contab.dao.ProdutoDAO;
import br.com.rfalessandro.contab.model.ClienteModel;
import br.com.rfalessandro.contab.model.PedidoModel;
import br.com.rfalessandro.contab.model.PedidoProdutoModel;


@Dependent
public class  CadastrarPedidoService {

	
	@Inject
	private PedidoDAO pedidoDAO;
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private PedidoProdutoDAO pedidoProdutoDAO;
	
	@Inject
	private ProdutoDAO produtoDAO;
	
	
	@Transactional(value=TxType.REQUIRED)	
	public void cadastrarPedido(PedidoModel pedido) throws Exception
	{
		List<PedidoProdutoModel> lsPedidoProduto = pedido.getLsProdutos();
		if(lsPedidoProduto == null || lsPedidoProduto.size() <= 0) {
			throw new Exception(" O pedido deve conter pelo menos um produto! ");
		}
		
		ClienteModel cliente = pedido.getCliente();
		if(cliente == null) {
			throw new Exception("O pedido deve conter um cliente! ");
		}	
		cliente.setTelefone(cliente.getTelefone().replaceAll("[^\\d]", ""));
		cliente.setNrDocumento(cliente.getNrDocumento().replaceAll("[^\\d]", ""));
		clienteDAO.salvar(cliente);
		pedidoDAO.salvar(pedido);
		for(Iterator<PedidoProdutoModel> it = lsPedidoProduto.iterator(); it.hasNext();) { 
			PedidoProdutoModel pedidoProduto = it.next();
			pedidoProduto.setPedido(pedido);
			produtoDAO.salvar(pedidoProduto.getProduto());			
			pedidoProdutoDAO.salvar(pedidoProduto); 
		} 
	}
	
	@Transactional(value=TxType.REQUIRED)	
	public void editarPedido(PedidoModel pedido) throws Exception
	{
		List<PedidoProdutoModel> lsPedidoProduto = pedido.getLsProdutos();
		if(lsPedidoProduto == null || lsPedidoProduto.size() <= 0) {
			throw new Exception(" O pedido deve conter pelo menos um produto! ");
		}
		
		ClienteModel cliente = pedido.getCliente();
		if(cliente == null) {
			throw new Exception("O pedido deve conter um cliente! ");
		}	
		cliente.setTelefone(cliente.getTelefone().replaceAll("[^\\d]", ""));
		cliente.setNrDocumento(cliente.getNrDocumento().replaceAll("[^\\d]", ""));
		
		clienteDAO.editar(cliente); 
		PedidoModel attached = pedidoDAO.editar(pedido);  
		
		pedidoProdutoDAO.removerAllByPedido(pedido);
		for(Iterator<PedidoProdutoModel> it = lsPedidoProduto.iterator(); it.hasNext();) { 
			PedidoProdutoModel pedidoProduto = it.next(); 
			pedidoProduto.setCdPedidoProduto(0);
			pedidoProduto.setPedido(attached);
			pedidoProduto.getProduto().setCdProduto(0);
			produtoDAO.salvar(pedidoProduto.getProduto());			
			pedidoProdutoDAO.salvar(pedidoProduto); 			
		} 
	}
		
	
	
}
