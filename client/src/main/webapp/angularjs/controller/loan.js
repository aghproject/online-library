libraryApp.controller("LoanController", function ($scope, $http) {
    $scope.books = {};
    $scope.loans = {};
    $scope.showView = false;
    $scope.response = {};
    $scope.data = {};
    $scope.showReservation = false;
    $scope.bookId;

    $scope.getBooks = function(userId) {
        console.log("getBooks works, userId: " + userId);
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
    
    $scope.getLoans = function(userId) {
        console.log("getLoans works, userId: " + userId);
        $scope.userId = userId;
        if ($scope.showView) {
            $scope.showView = false;
        } else {
            $scope.showView = true;
        }

        if ($scope.showView) {
            $http.get("/loan?user_id="+userId+"")
                .then(function (response) {
                    $scope.loans = response.data.content;
                    console.log($scope.loans);
                }, function (response) {});
        }
    }
    
    $scope.submit = function (bookId, userId) {
        $scope.bookId = bookId;
        $scope.data = {
            "userId" : userId,
            "bookId" : bookId
        };
        
        $http.post("/loan", $scope.data)
            .then(function (response) {
                $scope.response = response.data;
                /* todo: display response and activate reservation if no free copy of book */
                $scope.showReservation = true;
                console.log("loan post request success!!!");
            }, function (response) {});
    };
});
