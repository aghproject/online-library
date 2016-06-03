<!DOCTYPE html>
<html ng-app='OnlineLibrary'>
<head>
    <meta charset="utf-8"/>
    <title>Online Library</title>

    <!-- LIBRARIES -->
    <script src="vendor/angular-1.4.5/angular.min.js"></script>
    <script type="text/javascript" src="vendor/angular-1.4.5/angular-route.min.js"></script>
    <script type="text/javascript" src="vendor/angular-1.4.5/angular-resource.min.js"></script>

    <!-- CONTROLLERS -->
    <script src="angularjs/controller/login.js"></script>
    <script src="angularjs/controller/loan.js"></script>
    <script src="angularjs/controller/reservation.js"></script>
    <script src="angularjs/controller/returnBook.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="style/style.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</head>
<body>
<div id="container">
    <div id="header">
        <p>Online Library Web App</p>
    </div>

    <div ng-controller="LoginController">
        <div class="login">
            <form ng-submit="submit()" ng-show="notAuth">
                <div class="topic">Login</div>
                <div ng-if="response.success == false">{{response.msg}}</div>
                <div ng-if="response.success == true">{{response.msg}}</div>
                <p><input type="text" name="email" ng-model="email"/></p>
                <p><input type="password" name="password" ng-model="password"/></p>
                <p><input type="submit" id="submit" value="Submit"/></p>
            </form>
        </div>

        <div ng-show="!notAuth">
            <p>{{response.msg}}</p>
            <div class="container">
                <div>
                    <div ng-controller="LoanController">
                        <ng-include src="'view/booklist.html'"></ng-include>
                    </div>
                    <div ng-controller="LoanController">
                        <ng-include src="'view/loanbook.html'"></ng-include>
                    </div>
                    <div ng-controller="BookReturnController">
                        <ng-include src="'view/returnbook.html'"></ng-include>
                    </div>
                </div>
            </div>
        </div>

    </div><!-- end of LoginController -->

</div>
</body>
</html>



