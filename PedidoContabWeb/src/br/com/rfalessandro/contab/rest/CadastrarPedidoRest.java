package br.com.rfalessandro.contab.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rfalessandro.contab.model.PedidoModel;
import br.com.rfalessandro.contab.service.CadastrarPedidoService;

@Path("/pedido")
public class CadastrarPedidoRest {
	
	
	@Inject
	private CadastrarPedidoService service;
	
	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON }) 
	public Response create(PedidoModel pedido) {
		try {
			service.cadastrarPedido(pedido);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		
	}
	
	@POST
	@Path("/edit")
	@Consumes({ MediaType.APPLICATION_JSON }) 
	public Response edit(PedidoModel pedido) {
		try {
			service.editarPedido(pedido);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		
	}
	
}
