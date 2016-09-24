package br.com.rfalessandro.contab.rest;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rfalessandro.contab.model.PedidoModel;
import br.com.rfalessandro.contab.model.PedidoProdutoModel;
import br.com.rfalessandro.contab.service.PedidoService;

@Path("/pedido")
public class PedidoRest {

	@Inject
	private PedidoService service;
		
 
	@GET
	@Path("/find")
	@Consumes({ MediaType.TEXT_PLAIN })
	@Produces({ MediaType.APPLICATION_JSON }) 
	public Response find(@QueryParam("codigo") String codigo) {
		List< PedidoModel > lsPedidos = service.buscarPedidos(new BigDecimal(codigo));
		if(lsPedidos != null) {
			for(Iterator<PedidoModel> it = lsPedidos.iterator(); it.hasNext(); ) {
				PedidoModel p = it.next();
				p.setLsProdutos(null);
				p.getCliente().setLsPedido(null);
			}
		}
		return Response.ok(lsPedidos).build();
	}
	
	@GET
	@Path("/find/{cdPedido}")
	@Consumes({ MediaType.TEXT_PLAIN })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response find(@PathParam("cdPedido") Long cdPedido) {
		PedidoModel  pedido = service.buscarPedido(cdPedido);
		if(pedido != null) {
			for(Iterator<PedidoProdutoModel> it = pedido.getLsProdutos().iterator(); it.hasNext(); ) {
				PedidoProdutoModel pp = it.next();		
				pp.setPedido(null);
			}
			pedido.getCliente().setLsPedido(null);
		}
		return Response.ok(pedido).build();
	}

	
} 
