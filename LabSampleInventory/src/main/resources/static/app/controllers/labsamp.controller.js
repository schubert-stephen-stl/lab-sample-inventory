angular.module('labsampApp')
.controller('LabsampController', ['$scope', '$filter', 'Labsamps',  function LabsampController($scope, $filter, Labsamps) {
	$scope.formData = {};
	$scope.shelfNameFormat = /sh+\-[a-zA-Z0-9]+\-[0-9]/;  
	
    Labsamps.get()
    .success(function(data) {
        $scope.labsamps = data;
    });
    
    $scope.createLabsamp = function() {

        if(!$scope.labsampForm.$valid) {
            return;
        }
        Labsamps.create($scope.formData)
        .success(function(data) {
            $scope.formData = {}; // clear the form
            $scope.labsampForm.$setPristine(); // clear for proper display of validation rules
            $scope.labsamps.push(data);
        });
    };

    $scope.deleteLabsamp = function(id) {
        Labsamps.delete(id)
        .success(function(data) {
        	angular.forEach($scope.labsamps, function(labsamp, index){
                if(labsamp.id == id) {
                	$scope.labsamps.splice(index, 1);
                }
        	});
        });
    };

    $scope.saveLabsamp = function(labsamp) {
        Labsamps.update(labsamp)
        .success(function(data) {
            $scope.editedLabsamp = {};
        });
    };

    $scope.editedLabsamp = {};

    $scope.editLabsamp = function(labsamp) {
        $scope.editedLabsamp = labsamp;
    }

    $scope.revertLabsamp = function() {
        $scope.editedLabsamp = {};
    }

}]).directive('labsampFocus', ['$timeout', function($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            scope.$watch(attrs.labsampFocus, function(newVal) {
                if(newVal) {
                    $timeout(function(){
                        element[0].focus();
                    }, 0, false)
                }
            });
        }
    }
}]);
