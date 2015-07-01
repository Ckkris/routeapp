'use strict';

var app = angular.module('bankingApp', ['ngRoute',
                                        'routeAppControllers'
                                        ]);

//ROUTAGE__________________________________________________________________________________________________________________

//QUESTION : COMMENT METTRE PLUSIEURS CONTROLEUR POUR UN WHEN ??

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/Synthese', {templateUrl:'features/synthese.html'})
    .when('/Virement', {templateUrl:'features/virement.html'})
    .when('/Client', {templateUrl:'features/client.html'})
    .when('/Compte', {templateUrl:'features/compte.html'})
    ;
}]);



////On peut ajouter un 'var' du fait de sa présence dans le premier 'var' : 'routeAppControllers'

//Dans la vue, pas obligé d'ajouter ng-controller dans la balise html

var routeAppControllers = angular.module('routeAppControllers', []); 

//Controleur de la vue "synthese"____________________________________________________________________________________________

//Controleur synthese 1 : affichage d'une variable msg----------------------------- OK

//routeAppControllers.controller('SyntheseCtrl1', ['$scope',
//    function($scope)
//    	{ 
//			$scope.msg1 = "Bienvenue sur la page d'accueil";
//    	}
//	]);



//RETOUR SUR VAR = APP ____________________________________________________________________________________________________________________




//ESSAI SUR INDEX Connexion------------------------------------------NOK

app.controller('ControlleurConnexion', function($scope, $http) {
	
//	var utilisateursDatabase = $http.get('/getAllClients').success(function(data){$scope.contacts = data;});
	$scope.someBoolean = true;
	
	var utilisateursDatabase=[];
	
	$http.get('/getAllClients').success(function(data){
		//$scope.contacts = data;
		utilisateursDatabase=data;
		
//		Visualiser la valeur attendu
//		utilisateur = utilisateursDatabase[0].login;
//		$scope.utilisateur;
	});
	
		$scope.connexion = function(){
	    var connected = false;
	    for(var i in utilisateursDatabase){
	    	
	        var utilisateur = utilisateursDatabase[0]; //Premier élément de la chaine d'objet (premier client)
	        
	        if(utilisateur.password===$scope.identifiants){
	            connected = true;
	            break;
	        }
	    }
	    if(connected){
	        $scope.resultat = "Vous êtes connecté";
	        $scope.someBoolean = false;
	    }else{
	        $scope.resultat = " Mot de passe mauvais. Veuillez réessayer";
	    }
	}
});


//Controller liste client----------------------------------------

app.controller('ControllerAllClients', 
		
		function($scope, $http) 
		{
			$scope.contacts = [];
			$scope.user = {
					login: "login...",
					nom: "nom...",
					prenom: "prenom...",
							};
	
			$scope.saveClient = function() 
				{
					var client = $scope.user;
					$http.post('/client', client).success(function(data){$scope.user = data;});
				};
	
			$scope.asyncLoadClients = function() 
				{
					$http.get('/getAllClients').success(function(data){$scope.contacts = data;});
				}
		}
	);

//Controller liste compte----------------------------------------

app.controller('ControllerAllComptes', function($scope, $http) {

//	$scope.courant = [];
//	$scope.user = {
//			id_compte: "id_compte...",
////			plafond: "plafond...",
////			montant: "montant...",
//	};
//	
//	$scope.saveCompte = function() {
//		var compte = $scope.user;
//		$http.post('/compte', compte).success(function(data1) {
//			$scope.user = data1;
//		});
//	};
	
	$scope.asyncLoadCourant = function() {
		$http.get('/getAllCourants').success(function(data1) {
			$scope.courant = data1;
		});
	}
	
	$scope.asyncLoadPel = function() {
		$http.get('/getAllPels').success(function(data1) {
			$scope.pel = data1;
		});
	}
	
	$scope.asyncLoadCourantNeg = function() {
		$http.get('/getCourantNegatif()').success(function(data1) {
			$scope.courantneg = data1;
		});
	}
});

