package br.com.rfalessandro.contab.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.rfalessandro.contab.dao.ProdutoDAO;
import br.com.rfalessandro.contab.model.ProdutoModel;

@Dependent
public class ProdutoService {

	@Inject
	private ProdutoDAO produtoDAO;
	
	public List<ProdutoModel> buscarProdutos(String desc)
	{
		if(desc == null) {
			desc = "";
		}
		return produtoDAO.getAllByDesc(desc);
	}
	
	
	@Transactional(value=TxType.REQUIRED)
	public  ProdutoModel cadastarProduto(ProdutoModel produto) {
		return produtoDAO.salvar(produto);
	}

}
