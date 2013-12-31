/**
 * Created by jordancote on 12/30/13.
 */

var phonecatApp = angular.module('canvassApp', [
    'ngRoute',
    'landingControllers',
    'loginControllers'
]);

phonecatApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/landing', {
                templateUrl: 'partials/landing.html',
                controller: 'LandingCtrl'
            }).
            when('/login', {
                templateUrl: 'partials/login.html',
                controller: 'LoginCtrl'
            }).
            otherwise({
                redirectTo: '/landing'
            });
    }]);
