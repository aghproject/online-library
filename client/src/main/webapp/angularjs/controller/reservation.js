/**
 * Created by psk on 26.05.16.
 */
libraryApp.controller("ReservationController", function ($scope, $http) {
    $scope.data = {};
    $scope.response = {};
    $scope.showReservationMsg = false;

    $scope.reservation = function(userId, bookId) {
        console.log("reservation works, userId: " + userId);
        $scope.data = {
            "userId" : userId,
            "bookId" : bookId
        }

        $http.post("/book/reservation", $scope.data)
            .then(function (response) {
                $scope.response = response.data;
                $scope.showReservationMsg = true;
                /* todo: display response msg */

                console.log("reservation post request success!");
            }, function (response) {});
    };
});