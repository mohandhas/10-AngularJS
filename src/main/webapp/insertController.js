angular.module('insert',[])

    .controller('addController',function($scope,insertService)
        {
    			$scope.id;
            $scope.name;
            $scope.email;
            $scope.phone;
            $scope.insertEmployee = function() {
            	var employee = 
                    {
                        "id" : $scope.id,
                        "name": $scope.name,
                        "email": $scope.email,
                        "phone": $scope.phone
                    }
            	console.log(employee);
                insertService.addEmployee(employee);
                setTimeout("location.reload(true);", 1*60);

//                alert("REGISTERED! return to the Home page");
            }
        
        })

    .service('insertService',['$http',function($http)
        {
            this.addEmployee=function(employee){
            	console.log(employee);
            		return $http({ url : 'http://localhost:8080/RESTAssignment/webapi/employee',
            			method : 'POST',
            			data: employee})
                .then(function(response)
                {
                		console.log(employee);
                }, function(err){
                    console.log(err);
                })
            }
        }])