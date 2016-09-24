package br.com.rfalessandro.contab.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.Query;

import br.com.rfalessandro.contab.model.PedidoModel;
import br.com.rfalessandro.contab.model.PedidoProdutoModel;

@Dependent
public class PedidoProdutoDAO extends BaseDAO<PedidoProdutoModel> {

	public void removerAllByPedido(PedidoModel pedido) {
		Query qDeleteVisitors = entityManager.createQuery("delete from PedidoProdutoModel obj where obj.pedido.cdPedido in (?1)");
		qDeleteVisitors.setParameter(1, pedido.getCdPedido());
		qDeleteVisitors.executeUpdate();
		
	}

	
	 
	
	
}
