angular.module('index',["ngRoute"])

	.controller('indexController',function($scope,getService,deleteService,$timeout)
	 {
		$scope.empolyee;
		$scope.empList = getService.getAllEmployees()
						.then(function(data)
						{
							$scope.employee=data;
						})	
		
		$scope.deleteEmployee = function(id) {
    				console.log(id);
                deleteService.deleteEmployee(id);
                setTimeout("location.reload(true);", 1*60);
            }
		
		
	 })
	 
	 .service('getService',['$http',function($http)
        {
		 	this.getAllEmployees=function(){
                return $http.get("http://localhost:8080/RESTAssignment/webapi/employee")
                .then(function(response)
                {
                		return response.data;
                		
                }, function(err){
                    console.log(err);
                })
            }
        }])
        
        .service('deleteService',['$http',function($http)
        {
            this.deleteEmployee=function(id){
                $http.delete('http://localhost:8080/RESTAssignment/webapi/employee/'+id)
                .then(function(response)
                {
                }, function(err){
                    console.log(err);
                })
            }
        }])

        .config(function($routeProvider, $locationProvider) {
            $routeProvider
            .when("/", {
                templateUrl : "index.html"
            })
            .when("/insert", {
                templateUrl : "insert.html",
                controller : 'insertController.js'
            })
            .when("/get", {
                templateUrl : "get.html",
                controller : 'get.js'
            });
            $locationProvider.html5Mode(true);
        });