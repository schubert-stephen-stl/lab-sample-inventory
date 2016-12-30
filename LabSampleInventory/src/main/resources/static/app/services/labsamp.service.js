angular.module('labsampApp')
.factory('Labsamps', ['$http', function($http) {
	return {
		get: function() {
			return $http.get('/api/labsamps');
		},

		create: function(labsampData) {
			return $http.post('/api/labsamps', labsampData);
		},

		delete: function(id) {
			return $http.delete('/api/labsamps/' + id);
		},

		update: function(labsampData) {
			return $http.put('/api/labsamps/' + labsampData.id, labsampData);
		}
	}
}]);