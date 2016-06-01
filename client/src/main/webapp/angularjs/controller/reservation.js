/**
 * Created by psk on 26.05.16.
 */
libraryApp.controller("ReservationController", function ($scope, $http) {
    $scope.data = {};

    $scope.reservation = function(userId, bookId) {
        console.log("reservation works, userId: " + userId);
        $scope.data = {
            "userId" : userId,
            "bookId" : bookId
        }

        $http.post("/book/reservation", $scope.data)
            .then(function (response) {
                $scope.response = response.data;
                /* todo: display response with number on waiting list */

                console.log("loan post request success!!!");
            }, function (response) {});
    };
});