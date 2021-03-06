/**
 * Created by psk on 26.05.16.
 */
libraryApp.controller("BookReturnController", function ($scope, $http) {
    $scope.showView = false;
    $scope.response = {};
    $scope.data = {};
    $scope.showReturnMsg = false;
    
    $scope.returnBook = function(userId) {
        console.log("return works, userId: " + userId);
        if ($scope.showView) {
            $scope.showView = false;
            $scope.showReturnMsg = false;
        } else {
            $scope.showView = true;
        }
    };

    $scope.submit = function (copyId, userId) {
        $scope.data = {
            "userId" : userId,
            "copyId" : copyId
        };

        $http.post("/loan/return", $scope.data)
            .then(function (response) {
                $scope.response = response.data;
                $scope.showReturnMsg = true;
                
                console.log("return book post request success!");
            }, function (response) {});
    };
});
