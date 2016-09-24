
angular.module('pedidoContabApp').controller('pedidoCreateCtrl', 	
	function ($scope, $http, $mdToast, $window, produtoService, pedidoService, $routeParams) {
		var clearForm = function()
		{
			$scope.pedido = {};
			$scope.pedido.lsProdutos = [];
			$scope.pedido.valorTotal = 0.0;
			$scope.pedido.cliente = {}
			$scope.pedido.cliente.idTipoPessoa = 0;		
			$scope.pedidoProduto = {};
			$scope.pedidoProduto.produto = {};			
		}
		
		clearForm();
		
		 
		if($routeParams != null && $routeParams.cdPedido != null && $routeParams.cdPedido > 0) {
			$scope.cdPedido = $routeParams.cdPedido;
			pedidoService.pesquisarPedidoFull($routeParams.cdPedido)
			.then(
				function(response) {
					if(response.data != null) {
						var dt = new Date();
						dt.setTime(response.data.dataEmissao);
						response.data.dataEmissao = dt;
						$scope.pedido = response.data;
					}
				},
				function(data, status) {
					$mdToast.show( 
	               	      $mdToast.simple()
	               	        .textContent("Não existe este pedido!!")	              	        
	               	        .theme('error-toast')
	               	        .hideDelay(8000)
	               	    );
			});
		}
		
		
		
		$scope.prodDescrValid = true;
		$scope.prodQtdeValid = true;
		$scope.prodCodigoValid = true;
		$scope.prodValorValid = true;
		

	
		$scope.getMaskPessoa = function() {
			return  $scope.pedido.cliente.idTipoPessoa == 0 ? "999.999.999-99" : "99.999.999/9999-99";
		}
		
		
		//métodos para validar os campos do pedido produto
		$scope.validaPedidoProdutoDescricao = function() {			
			var error = false;			
			if($scope.pedidoProduto.produto.descricao == null || $scope.pedidoProduto.produto.descricao.length <= 0) {
				   $scope.prodDescrValid = false;
				   error = true;
			}else {
				$scope.prodDescrValid = true;
			}
			return error;
		}
		
		$scope.validaPedidoProdutoQuantidade = function() {			
			var error = false;			
			if($scope.pedidoProduto.quantidade == null) {
				   $scope.prodQtdeValid = false;
				   error = true;
			}else {
				$scope.prodQtdeValid = true;
			}
			return error;
		}
		
		$scope.validaPedidoProdutoCodigo = function() {			
			var error = false;			
			if($scope.pedidoProduto.produto.codigo== null) {
				   $scope.prodCodigoValid = false;
				   error = true;
			}else {
				$scope.prodCodigoValid = true;
			}
			return error;
		}
		
		$scope.validaPedidoProdutoValor = function() {			
			var error = false;			
			if($scope.pedidoProduto.produto.valorUnitario == null) {
				   $scope.prodValorValid = false;
				   error = true;
			}else {
				$scope.prodValorValid = true;
			}
			return error;
		}
		
		
		 
		$scope.addProduto = function() {
			//método para adicionar pedido prdouto
			var error = false;
			
			error = $scope.validaPedidoProdutoDescricao();
			error = $scope.validaPedidoProdutoQuantidade();
			error = $scope.validaPedidoProdutoCodigo();
			error = $scope.validaPedidoProdutoValor();
			
			if(error) {
				return;
			}
			$scope.pedido.valorTotal += $scope.pedidoProduto.produto.valorUnitario * $scope.pedidoProduto.quantidade;
			var oldPos = $scope.pedidoProdutoEditPos;
			if(oldPos == null) {
				$scope.pedido.lsProdutos.push($scope.pedidoProduto);
			}else {
				var old = $scope.pedido.lsProdutos[oldPos];				
				$scope.pedido.valorTotal -= old.produto.valorUnitario * old.quantidade;;
				$scope.pedidoProdutoEditPos = null;
				$scope.pedido.lsProdutos[oldPos] = $scope.pedidoProduto;
			}
			//reseta pedido produto
			$scope.pedidoProduto = {}
			$scope.pedidoProduto.produto = {};
			
			
			
		}
		
		$scope.submit_form = function() {
			//método para enviar o cadastro

			if($scope.cdPedido == null) {
				pedidoService.cadastrarPedido($scope.pedido).success(serviceSuccess).error(serviceError);
			}else {
				pedidoService.editarPedido($scope.pedido).success(serviceSuccess).error(serviceError);
			}
		}		
	
		var serviceSuccess = 
			function(data, status, headers, config) {                
                $window.scrollTo(0, 0);
                clearForm();
                $mdToast.show( 
              	      $mdToast.simple()
              	        .textContent("Registro enviado com sucesso!!")	              	        
              	        .theme('success-toast')
              	        .hideDelay(8000)
              	    );
                
            }
		
		var serviceError = function(data, status, headers, config) {
			$window.scrollTo(0,0);
        	$mdToast.show( 
		       	      $mdToast.simple()
		       	        .textContent("Aconteceu algum erro no servidor!!")	              	        
		       	        .theme('error-toast')
		       	        .hideDelay(8000)
		       	    );
		}
		
		$scope.selectPedidoProduto = function(event)
		{
			var pos = angular.element(event.currentTarget).controller('mdChips').selectedChip;
		      
		    if(pos >= 0 && pos < $scope.pedido.lsProdutos.length ) {
		    	angular.copy($scope.pedido.lsProdutos[pos], $scope.pedidoProduto);
		    	$scope.pedidoProdutoEditPos = pos;
		    }
		      
		}
		
	}
);