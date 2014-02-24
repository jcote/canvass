angular.module('canvassApp')
    .controller('LandingCtrl', ['$scope','Contacts', 'VoteChart', function($scope, Contacts, VoteChart){

        $scope.isSuccessShown = false;
        $scope.isErrorShown = false;

        $scope.create = function(item)
        {
            console.log(item);
            var contact = new Contacts(item);
            contact.email = item.email;
            contact.zipCode = item.zipCode;
            console.log(contact);

            contact.$save(
              function(data, responseHeaders) { 
                $scope.isErrorShown = false;
                $scope.isSuccessShown = true;
              },
              function(data, responseHeaders) {
                $scope.isSuccessShown = false;
                $scope.isErrorShown = true;
            });

        };


        $scope.$watch('avalue', function(newVal, oldVal) {
            if (isNaN($scope.avalue) || $scope.avalue < 0 || $scope.avalue > 100) {
                $scope.avalue = 33;
            }

            //angular.element('#vote-results-donut').empty();
            VoteChart.draw($scope.avalue);
        });

    }]);
