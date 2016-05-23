<!DOCTYPE html>
<html ng-app='OnlineLibrary'>
<head>
    <meta charset="utf-8"/>
    <title>Online Library</title>

    <!-- LIBRARIES -->
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>

    <!-- CONTROLLERS -->
    <script src="angularjs/controller/login.js"></script>

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
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <td>Id</td>
                        <td>Wypozyczona</td>
                        <td>Zwrot</td>
                        <td>Tytul</td>
                        <td>Kategoria</td>
                        <td>Autor</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="item in book">
                        <td>{{ item.id }}</td>
                        <td>{{ item.startDate }}</td>
                        <td>{{ item.endDate }}</td>
                        <td>{{ item.copy.book.title }}</td>
                        <td>{{ item.copy.book.category.name }}</td>
                        <td>{{ item.copy.book.author.name }} {{item.copy.book.author.lastName}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div><!-- end of LoginController -->

</div>
</body>
</html>



