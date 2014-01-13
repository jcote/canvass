/* Created by alaaawad on 12/30/13.*/

var canvassAdminApp = angular.module('canvassAdminApp', [
    'ngRoute',
    'landingControllers'
]);


canvassAdminApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
	        when('/landing', {
	            templateUrl: 'partials/landing.html',
	            controller: 'LandingCtrl'
	        }).
            otherwise({
                redirectTo: '/landing'
            });
    }]);

