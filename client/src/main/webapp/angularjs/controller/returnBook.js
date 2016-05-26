/**
 * Created by psk on 26.05.16.
 */
libraryApp.controller("BookReturnController", function ($scope, $http) {
    $scope.showView = false;
    
    $scope.returnBook = function(userId) {
        console.log("return works, userId: " + userId);
        if ($scope.showView) {
            $scope.showView = false;
        } else {
            $scope.showView = true;
        }
    };
});
