angular.module('canvassApp')
    .directive("navbar", function() {
      return {
        restrict: "E",
        replace: true,
        transclude: true,
        controller: 'NavbarCtrl',
        templateUrl: 'partials/navbar.html'
      };
    });