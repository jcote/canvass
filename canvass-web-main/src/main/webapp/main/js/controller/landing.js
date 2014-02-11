angular.module('canvassApp')
	.controller('LandingCtrl', ['$scope','Contacts', function($scope, Contacts){
	    $scope.create = function(item)
	    {
	    	console.log(item);
	        var contact = new Contacts(item);
	        contact.email = item.email;
	        contact.firstName = item.firstName;
	        contact.lastName = item.lastName;
	        contact.zipCode = item.zipCode;
	        console.log(contact);
	        contact.$save();
	    }
	   
	}]);
