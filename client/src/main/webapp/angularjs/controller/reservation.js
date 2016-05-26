/**
 * Created by psk on 26.05.16.
 */
libraryApp.controller("ReservationController", function ($scope, $http) {
    $scope.showView = false;

    $scope.reservation = function(userId) {
        console.log("reservation works, userId: " + userId);
        if ($scope.showView) {
            $scope.showView = false;
        } else {
            $scope.showView = true;
        }
    };
});