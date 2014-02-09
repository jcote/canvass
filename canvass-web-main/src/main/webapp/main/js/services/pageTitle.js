angular.module('canvassApp')
    .factory('PageTitle', function() {
        return {
            setTitle: function(newTitle) { 
                angular.element(document).ready(function() {
                    if (newTitle) {
                        document.title = newTitle + ' | Canvass';
                    } 
                });
            }
        };
    });