package br.com.rfalessandro.contab.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rfalessandro.contab.model.ClienteModel;
import br.com.rfalessandro.contab.service.ClienteService;


@Path("/cliente")
public class ClienteRest {

	@Inject
	private ClienteService service;
	
	
	@GET
	@Path("/find")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public Response find(@QueryParam("desc")  String nome) 
	{
		return Response.ok(service.buscarClientes(nome)).build();
	}
	
	
	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response create(ClienteModel cliente) 
	{ 
		try {
			service.cadastarCliente(cliente);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		
	}
	
	
	@GET
	@Path("/cad/aux")
	public Response cadAux() 
	{ 
		try {
			ClienteModel model = new ClienteModel();
			model.setEmail("dfsjk@gljd.com");
			model.setIdTipoPessoa((byte) 0);
			model.setNrDocumento("3432423423");
			model.setTelefone("041959533190");
			model.setNome("Paulo José Passos");		
			service.cadastarCliente(model);
			return Response.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
		
	}
	
	
	
}
