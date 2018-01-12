angular.module('get',[])

	.controller('getController',function($scope,getService)
	 {
		$scope.id;
		var id=$scope.id;
		
		$scope.getEmployee = function(){
				getService.getEmployee($scope.id)
						.then(function(data)
						{
							getService.getEmployee($scope.id);
							$scope.employee=data;
							console.log(data);
						});
		}
	 })
	 
	 .service('getService',['$http',function($http) 
		 {
		 	this.getEmployee=function(id)
		 	{
                return $http.put("http://localhost:8080/RESTAssignment/webapi/employee/"+id)
                .then(function(response)
                {
                		return response.data;
                		
                }, function(err){
                    console.log(err);
                })
            }
        }])
        
        