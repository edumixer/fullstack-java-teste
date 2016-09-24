angular.module('pedidoContabApp').controller("indexCtrl", function($scope, $http, $mdSidenav, $location, $window, $mdToast) {

		
		$scope.toggleMenu =  function() {
			$mdSidenav('left').toggle();
		}
		
		
		$scope.goTo =  function(path) {
			
			 $location.path( path );
			 $mdSidenav('left').toggle();
		 
			 $window.scrollTo(0, 0);
		}
		
		
		

		
	});