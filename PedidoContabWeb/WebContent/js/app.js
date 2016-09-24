{
	var app = angular.module("pedidoContabApp", [ "ngMaterial", "ngRoute", "ngMessages"]);
	
	
	app.value('basePath', '/PedidoContabWeb/rest');
	
	
	app.config(function($routeProvider) {
        $routeProvider

            .when('/pedido-create/:cdPedido', {
                templateUrl : 'pages/pedido/pedido-create.html',
                controller  : 'pedidoCreateCtrl',
                
            })
            .when('/pedido-find', {
                templateUrl : 'pages/pedido/pedido-find.html',
                controller  : 'pedidoFindCtrl'
            });
    });
	app.config(function($mdThemingProvider) {
		$mdThemingProvider.theme('error-toast')
		$mdThemingProvider.theme('success-toast')
	});
	
	
}