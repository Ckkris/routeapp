'use strict';

var app = angular.module('bankingApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/Hello', {templateUrl:'features/hello.html'})
    .otherwise({templateUrl:'features/other.html'})
    ;
}]);