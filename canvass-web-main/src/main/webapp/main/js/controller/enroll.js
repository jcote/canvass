angular.module('canvassApp')
	.controller('EnrollCtrl', ['$scope', '$http',
	    function ($scope, $http) {
		 $scope.isAlertShown = false;
		 $scope.alertStatus = "info";
		 
		 $scope.enroll = function(user) {
		  $http.defaults.headers.common['X-Canvass-Username'] = user.name;
		  $http.defaults.headers.common['X-Canvass-Hashpass'] = CryptoJS.SHA256('com.canvass|v1|' + user.name + '|' + user.password);
		  
		  $http.post('enroll').
		    success(function(data) {
			  $scope.alertText = "Success!";
			  $scope.alertStatus = "success";
			  $scope.isAlertShown = true;
			}).
		    error(function(data) {
			  $scope.alertText = "Error: " + data;
			  $scope.alertStatus = "danger";
			  $scope.isAlertShown = true;
			});
		  
		  $http.defaults.headers.common['X-Canvass-Username'] = '';
		  $http.defaults.headers.common['X-Canvass-Hashpass'] = '';
		 };
	    }]);

