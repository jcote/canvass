/**
 * Created by jordancote on 12/30/13.
 */

angular.module('canvassApp', ['ngRoute', 'ngSanitize'])
    .config(['$routeProvider', function($routeProvider) {

        $locationProvider.html5Mode(true);//pushstate

        $routeProvider.
            when('/landing', {
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
                redirectTo: '/landing'
            });
        }])

    // Angular now tests what urls are allowed. We should change this to only certain providers. 
    // For now, all are allowed. This is for user-input URLs.
    .config( ['$sceDelegateProvider', function($sceDelegateProvider) {
        $sceDelegateProvider.resourceUrlWhitelist([
            'self',
            '**'
        ]);
    }])