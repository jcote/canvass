
angular.module('canvassApp')
    .factory('Contacts', function($resource){
        return $resource('api/contact/contact/');
    });


