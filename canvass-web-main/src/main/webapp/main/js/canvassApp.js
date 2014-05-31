/**
 * Created by jordancote on 12/30/13.
 */

angular.module('canvassApp', ['ngRoute','ngResource', 'highcharts-ng'])
    .config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

       // Responds with 405 $locationProvider.html5Mode(true);//pushstate
       $locationProvider.html5Mode(true);

       // Should work. https://useiconic.com/community/#!/icon-aesthetic:angular-js
       $rootScope.$on('$viewContentLoaded', function() {
            IconicJS().inject('img.iconic')
       };

        $routeProvider.
            when('/', {
                templateUrl: 'partials/landing.html'
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
    .factory('DemoData', function (){
        return {
            "issues": [
                {
                    "title":"Require Employers Provide Reasonable Opportunity for Employees to Seek Legal Advice Before Signing a Noncompete Agreement ",
                    "votes":{
                        "for":10,
                        "against":4
                    }
                }
            ]
        };
    });
