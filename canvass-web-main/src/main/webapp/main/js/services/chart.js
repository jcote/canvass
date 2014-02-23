angular.module('canvassApp')
    .factory('VoteChart', function($resource){
        // initialize the chart once
        Morris.Donut({
            element: 'vote-results-donut',
            data: [
            {label: "Yes", value: 36.2},
            {label: "No", value: 8.3},
            {label: "Didn't Vote", value: 12.8},
            {label: "Not Signed Up", value: 42.7}
            ],
            formatter: function (y) { return y + "%" ;}
        });
    });