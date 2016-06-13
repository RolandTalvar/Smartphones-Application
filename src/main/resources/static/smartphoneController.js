/**
 * Created by rolandtalvar on 09/06/16.
 */

app.controller('smartphoneController', function($scope, $http) {
    window.scope = $scope;
    $scope.showEditSmartphone = false;
    $scope.showCreateSmartphone = false;

    $http.get("http://localhost:8011/SmartphonesApplication/service/smartphones")
        .then(function(response) {
            $scope.smartphones = response.data;
        });


    $scope.editSmartphone = function (id) {
        $scope.getSmartphone(id);
        $scope.showEditSmartphone = true;
        $scope.showCreateSmartphone = false;
    };

    $scope.saveSmartphone = function (smartphone) {
        $http.put("http://localhost:8011/SmartphonesApplication/service/smartphones/" + smartphone.id, smartphone)
            .then(function(response) {
                alert("Status: " + response.statusText + "\n\nSaved to database as object: " + JSON.stringify(response.data));
                $scope.getSmartphones();
            });

    };

    $scope.createNewSmartphone = function (smartphone) {
        $http.post("http://localhost:8011/SmartphonesApplication/service/smartphones", smartphone)
            .then(function(response) {
                alert("Status: " + response.statusText + "\n\nSaved to database as object: " + JSON.stringify(response.data));
                $scope.getSmartphones();
            });

    };

    $scope.getSmartphones = function () {
        $http.get("http://localhost:8011/SmartphonesApplication/service/smartphones")
            .then(function(response) {
                $scope.smartphones = response.data;
            });
        $scope.showEditSmartphone = false;
        $scope.showCreateSmartphone = false;
    };

    $scope.getSmartphone = function (id) {
        $http.get("http://localhost:8011/SmartphonesApplication/service/smartphones/" + id)
            .then(function(response) {
                $scope.editSmartphone = response.data;
            });
        $scope.showEditSmartphone = true;
        $scope.showCreateSmartphone = false;
    };

    $scope.deleteSmartphone = function (id) {
        $http.delete("http://localhost:8011/SmartphonesApplication/service/smartphones/" + id)
            .then(function(response) {
                $scope.getSmartphones();
            }, function errorCallback(response) {
                $scope.getSmartphones();
            });
    };

});