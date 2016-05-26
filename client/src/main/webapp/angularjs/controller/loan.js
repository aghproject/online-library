libraryApp.controller("LoanController", function ($scope, $http) {
    $scope.books = {};
    $scope.showView = false;

    $scope.loan = function(userId) {
        console.log("loan works, userId: " + userId);
        if ($scope.showView) {
            $scope.showView = false;
        } else {
            $scope.showView = true;
        }

        if ($scope.showView) {
            $http.get("/book")
                .then(function (response) {
                    $scope.books = response.data.content;
                    console.log($scope.books);
                }, function (response) {
                });
        }
    };
});
