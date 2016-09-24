

angular.module('pedidoContabApp').controller('pedidoFindCtrl', 	
	function ($scope,  $mdToast,  $http, produtoService, pedidoService, $location) {
		$scope.pedidos = []; 
		
		$scope.doFind = function() {
			$scope.pedidos = [];
			
			pedidoService.pesquisarPedido($scope.txtFind)
			.then(
				function(response) {
					$scope.pedidos = response.data;
				},
				function(data, status) {
					$mdToast.show( 
	               	      $mdToast.simple()
	               	        .textContent("Aconteceu algum erro no servidor!!")	              	        
	               	        .theme('error-toast')
	               	        .hideDelay(8000)
	               	    );
			});	
		}
		$scope.goToEdit = function(cdPedido) {
			 $location.path('pedido-create/'+cdPedido);
		}
	}


);