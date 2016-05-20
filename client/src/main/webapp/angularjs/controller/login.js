/**
* Created by psk on 07.05.16.
*/
var libraryApp = angular.module('OnlineLibrary', []);

libraryApp.controller('LoginController', function ($scope, $http) {
    $scope.data = {};
    $scope.email = "";
    $scope.password = "";
    $scope.response = {};
    $scope.notAuth = true;
    $scope.book = {};

    $scope.submit = function () {
        $scope.data = {
            "email": $scope.email,
            "password": $scope.password
        };
        $scope.email = "";
        $scope.password = "";

        $http.post("/login", $scope.data)
            .then(function (response) {
                $scope.response = response.data;
                if ($scope.response.success == true) {
                    $scope.notAuth = false;

                    $http.get("/loan?id="+$scope.response.content.id+"")
                        .then(function (response) {
                            $scope.book = response.data.content;
                            console.log($scope.book);
                        }, function (response) {});
                }
            }, function (response) {});
    };
});

