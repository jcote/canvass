angular.module('canvassApp')
    .controller('LoginCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.login = function(user) {
          $http.defaults.headers.common['X-Canvass-Username'] = user.name;
          $http.defaults.headers.common['X-Canvass-Hashpass'] = CryptoJS.SHA256('com.canvass|v1|' + user.name + '|' + user.password);
          $http.post('login').success(function(data) {
             alert('hi');
             });
          $http.defaults.headers.common['X-Canvass-Username'] = '';
          $http.defaults.headers.common['X-Canvass-Hashpass'] = '';
        };
    }]);

