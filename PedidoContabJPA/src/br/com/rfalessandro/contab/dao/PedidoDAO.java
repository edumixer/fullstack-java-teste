package br.com.rfalessandro.contab.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.Dependent;

import br.com.rfalessandro.contab.model.PedidoModel;

@Dependent
public class PedidoDAO extends BaseDAO<PedidoModel> {

	
	
	
	
	
	public List<PedidoModel> getAllByCodigo(BigDecimal codigo) {
		return entityManager.createNamedQuery("PedidoModel.getAllByCodigo", PedidoModel.class).setParameter(1, codigo).getResultList();
	}

	public PedidoModel getByCdPedido(Long cdPedido) {
		return entityManager.createNamedQuery("PedidoModel.getByCdPedido", PedidoModel.class).setParameter(1,cdPedido ).getSingleResult();
	}
	
	
	
}
