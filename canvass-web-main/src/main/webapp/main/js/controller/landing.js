angular.module('canvassApp')
    .controller('LandingCtrl', ['$scope', '$http',
        function ($scope, $http) {
            $scope.votes = Math.random();
        }]);

