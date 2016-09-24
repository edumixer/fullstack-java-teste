package br.com.rfalessandro.contab.rest;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rfalessandro.contab.model.ProdutoModel;
import br.com.rfalessandro.contab.service.ProdutoService;


@Path("/produto")
public class ProdutoRest {

	@Inject
	private ProdutoService service;
	
	
	@GET
	@Path("/find")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public Response find(@QueryParam("desc")  String desc) 
	{
		return Response.ok(service.buscarProdutos(desc)).build();
	}
	
	

	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response create(ProdutoModel produto) 
	{ 
		try {
			service.cadastarProduto(produto);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

	}
	
	
	
	
	@GET
	@Path("/cad/aux")
	@Produces({MediaType.APPLICATION_JSON})
	public Response cadAux() 
	{ 
		try {
			ProdutoModel model = new ProdutoModel();
			model.setDescricao("Mesa");
			model.setCodigo("001");
			model.setValorUnitario(new BigDecimal(33.4));
			service.cadastarProduto(model);
			
			model = new ProdutoModel();
			model.setDescricao("Cadeira");
			model.setCodigo("002");
			model.setValorUnitario(new BigDecimal(256.4));
			service.cadastarProduto(model);
			 
			model = new ProdutoModel();  
			model.setDescricao("Carro");
			model.setCodigo("003"); 
			model.setValorUnitario(new BigDecimal(67343.4));
			service.cadastarProduto(model);
			return Response.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		
	}
	
	
	
}
