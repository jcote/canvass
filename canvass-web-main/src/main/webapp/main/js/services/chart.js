angular.module('canvassApp')
    .service('VoteChart', function(){
        this.draw = function(aval) {
            Morris.Donut({
                element: 'vote-results-donut',
                data: [
                {label: "Yes", value: aval},
                {label: "No", value: 8.3},
                {label: "Didn't Vote", value: 12.8},
                {label: "Not Signed Up", value: 42.7}
                ],
                formatter: function (y) { return y + "%" ;}
            });
        };
    });