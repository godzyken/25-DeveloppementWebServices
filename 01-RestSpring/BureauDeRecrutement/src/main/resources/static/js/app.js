var app=angular.module("myApp",['ui.router']);




app.config(function($stateProvider,$urlRouterProvider){
	
	
	$stateProvider.state('Accueil',{
		url:'/Accueil',
		templateUrl:'views/Accueil.html',
		controller:'AccueilController'
	});
	
	
	
	
	$stateProvider.state('creationArrete',{
		url:'/creationArrete',
		templateUrl:'views/creationArrete.html',
		controller:'CreationArreteMController'
	});
	


       
});
      






app.controller('AdresseController',function($scope,$http){
    $scope.adresse={};
    $scope.mode=0;
    $scope.saveAdresse=function(){
              $http.post('http://localhost:8080/adresses', $scope.adresse)
               .then(function(data){
                $scope.adresse=data;
               
                console.log(data);
                $scope.mode=1;
                
               })
               .error(function(error){
                  console.log(error);
               });
       }
    
           $scope.modeform=function(){
           $scope.adresse={};
           $scope.mode=0;
       
       }
    
});






