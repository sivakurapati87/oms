'use strict';

App.controller('TaskController', ['$scope','$http','$rootScope','$state', function($scope,$http,$rootScope,$state) {

	$rootScope.current_state= $state.current.name;
	
	$scope.taskList = [{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	                   {taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'},
	{taskName:'design a website',assignedTo:'siva',dueDate:'10-04-2017',status:'Pending',description:'Do this task before 4th of April'}];
	
	
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
