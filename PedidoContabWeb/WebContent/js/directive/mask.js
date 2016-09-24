angular.module('pedidoContabApp').directive("mask", function(){
	return{
		require: "ngModel",
		link: function($scope, element, attrs, controller){
			
			
			var regexFormat = function(MASK_PATTERN){
				regex = "";
				if((/[0-9]+/g).test(MASK_PATTERN)){
					regex += "0-9";
				} 
				if((/[A-Za-z]+/g).test(MASK_PATTERN)){
					regex += "A-Za-z";
				} 
				if((/[/.]+/g).test(MASK_PATTERN)){
					regex += "/.";
				} 
				if((/[//]+/g).test(MASK_PATTERN)){
					regex += "/.";
				} 
				if((/[(|)]+/g).test(MASK_PATTERN)){
					regex += "()";
				} 
				if((/[ ]+/g).test(MASK_PATTERN)){
					regex += " ";
				} 
				if((/[/-]+/g).test(MASK_PATTERN)){
					regex += "/-";
				}
				return regex;
			};
			
			var format = function(data){
				var mask;
				if(attrs.maskFunction != undefined) {
					mask = $scope.$eval(attrs.maskFunction);
				}else {
					mask = attrs.maskStr;
				}
				MASK_PATTERN =  mask.replace(/\(.\)\?/g, "");
				if(MASK_PATTERN.length < data.length){
					MASK_PATTERN = mask.replace(/\(.\)\?/g, "9");
					data = data.substring(0, mask.length);
				}
				
				var dataFinal = "";
				
				for(var i=0; i<MASK_PATTERN.length; i++){
					if(MASK_PATTERN[i] && data[i]){
						
						var charMask = MASK_PATTERN[i];
						var charData = data[i];
						
						if(regexFormat(charMask) == regexFormat(charData)){
							dataFinal += charData;
						}else{
							if(/[-|.|(|)| |/]/g.test(charMask)){
								dataFinal += charMask + charData;
							}
						}
					}
				}
				
				return dataFinal;
			};
			
		
			element.bind("input", function(){
				var dataFinal = format(controller.$viewValue);		
				controller.$setViewValue(dataFinal);
				controller.$render();
			});
		}
	};	
});