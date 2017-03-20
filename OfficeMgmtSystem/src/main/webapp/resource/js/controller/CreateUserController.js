'use strict';

App.controller('CreateUserController', ['$scope','$http','$rootScope','$state', function($scope,$http,$rootScope,$state) {

	
	$rootScope.current_state= $state.current.name;
	
	$scope.userObj = {};
	
	
	
	
	$scope.saveOrUpdateAction = function(){
		$scope.userObj.effectiveFrom = $('#effectiveFromId').val();
		var response = $http.post(constants.localhost_port+constants.service_context+"/UserController/saveOrUpdateUser",$scope.userObj);
		response.success(function(data) {
			
			alert(data);
		});
		response.error(function() {
      	  console.error('Could not save or update jobtitles');
        });

	}
	
	
	
     /* $scope.obj={};
      
      $scope.init = function(){
    	$scope.obj.phone = "9603631480";
    	$scope.obj.email = "kssrao87@gmail.com";
    	$scope.obj.strTotalAmount = "100";
    	$scope.obj.firstname = "siva";
    	
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.LookUpController+'/hashCode').success(function(data) {
				$scope.hashJson = data;
			}).error(function() {
	      	  console.error('Could not get All Manufacturer List');
	        });
      };
      $scope.init();*/
}]);
