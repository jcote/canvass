angular.module('canvassApp')
    .controller('browseController', ['$scope', 'DemoData', function ($scope, DemoData) {
        $scope.issues = DemoData.issues;
    }]);

