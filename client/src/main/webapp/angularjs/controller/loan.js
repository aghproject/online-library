libraryApp.controller("LoanController", function ($scope, $http) {
    $scope.books = {};
    $scope.showView = false;
    $scope.response = {};
    $scope.data = {};

    $scope.loan = function(userId) {
        console.log("loan works, userId: " + userId);
        $scope.userId = userId;
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
    
    $scope.submit = function (copyId, userId) {
        $scope.data = {
            "userId" : userId,
            "copyId" : copyId
        };
        
        $http.post("/loan", $scope.data)
            .then(function (response) {
                $scope.response = response.data;
                console.log("loan post request success!!!");
            }, function (response) {});
    };
});
