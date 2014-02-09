/**
 * Created by jordancote on 12/30/13.
 */

angular.module('canvassApp', ['ngRoute'])
    .config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

       // Responds with 405 $locationProvider.html5Mode(true);//pushstate

        $routeProvider.
            when('/', {
                templateUrl: 'partials/landing.html',
                controller: 'LandingCtrl'
            }).
            when('/enroll', {
                templateUrl: 'partials/enroll.html',
                controller: 'EnrollCtrl'
            }).
            when('/login', {
                templateUrl: 'partials/login.html',
                controller: 'LoginCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
        }])