var app = angular.module('myApp', []);

app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.timeout = 20000;
}]);

app.all('/*', function (request, response, next) {
     response.header("Access-Control-Allow-Origin", "*");
     response.header("Access-Control-Allow-Headers", "*");
     response.header("Access-Control-Allow-Methods", "*");
     next();
});

app.controller('myCtrl', function($scope, $http) {
    this.retrieve = function() {
    $http.get('http://localhost:8071/api/stock-service/stock/' + $scope.name)
    .then(function (response) {
        console.log('inside'+ response);
        $scope.quotes = response.data;
    }, function (response) {
        console.log('came here');
    });
    }


    this.add = function() {
        var message = {
            userName: $scope.name,
            quotes: [$scope.quote]
        }
        $http.post('http://localhost:8071/api/db-service/stock/quotes/', message)
            .then(function(response) {
                $scope.quotes = response.data;
            }, function(response) {
                console.log('error..');
            });
    }
});


