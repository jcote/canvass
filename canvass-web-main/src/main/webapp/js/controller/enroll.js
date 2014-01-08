var enrollControllers = angular.module('enrollControllers', []);

enrollControllers.controller('EnrollCtrl', ['$scope', '$http',
    function ($scope, $http) {
	 $scope.enroll = function(user) {
	  $http.defaults.headers.common['X-Canvass-Username'] = user.name;
	  $http.defaults.headers.common['X-Canvass-Hashpass'] = CryptoJS.SHA256('com.canvass|v1|' + user.name + '|' + user.password);
	  $http.post('enroll').success(function(data) {
		 alert('hi');
		 });
	  $http.defaults.headers.common['X-Canvass-Username'] = '';
	  $http.defaults.headers.common['X-Canvass-Hashpass'] = '';
	 };
    }]);

