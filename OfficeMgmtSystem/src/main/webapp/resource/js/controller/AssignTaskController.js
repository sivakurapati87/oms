'use strict';

App.controller('AssignTaskController', ['$scope','$http','$rootScope','$state', function($scope,$http,$rootScope,$state) {

	
	$rootScope.current_state= $state.current.name;
	
	$scope.taskObj = {};
	
	$scope.saveOrUpdateAction = function(){
		alert(JSON.stringify($scope.taskObj));
	}
	
	
	  //This function is to get the selected value from auto population
    $scope.selectedUserNameAction = function(selected) {
        if (selected) {
//      	  $rootScope.transactionData.customerId = selected.title;
//      	  $scope.getCustomerInfoById();
        	alert(selected.originalObject.id);
        	$scope.taskObj.assignedToId = selected.originalObject.id;
        } else {
          console.log('cleared');
        }
      };

      
      $scope.getAllUsers = function(){
  		var response = $http.get(constants.localhost_port+constants.service_context+"/UserController/getAllUsers");
  		response.success(function(data) {
  			
  			$scope.userList = data;
  		});
  		response.error(function() {
        	  console.error('Could not Perform well');
          });
  	}
  	
  	
  	$scope.getAllUsers();
      
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
