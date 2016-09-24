angular.module('pedidoContabApp').factory('pedidoService', function($http, basePath) {
	
	return {
		
		pesquisarPedido: function(codigo) {
			return $http.get(basePath + '/pedido/find' + ( codigo == null ? "" : '?codigo='+ codigo));		
		},
		pesquisarPedidoFull: function(cdPedido) {
			return $http.get(basePath + '/pedido/find/' + cdPedido);		
		},
		
		cadastrarPedido: function(pedido) 
		{
			return $http.post(basePath + '/pedido/create', (pedido));
		},
		editarPedido: function(pedido) 
		{
			return $http.post(basePath + '/pedido/edit', (pedido));
		}
		
		
		
	}
});