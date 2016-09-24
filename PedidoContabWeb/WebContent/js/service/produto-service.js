angular.module('pedidoContabApp').factory('produtoService', function ($http, basePath){
	return {
		findProduto: function (desc) {
			return $http.get(basePath + '/produto/find' + ( desc == null ? "" : '?desc='+ desc));
		},
		createProduto: function (produto) {
			
			return $http.post( {
				url: basePath+ '/produto/create',
				contentType: 'json',
				data: produto					
			});
		}
		
	}
}
);