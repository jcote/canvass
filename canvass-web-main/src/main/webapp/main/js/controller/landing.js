var landingControllers = angular.module('landingControllers', []);

landingControllers.controller('LandingCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $scope.votes = Math.random();
    }]);

