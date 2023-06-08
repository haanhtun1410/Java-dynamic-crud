var app = angular.module("myApp", ["ngRoute", "ngStorage"]);

app.config(function ($routeProvider, $locationProvider) {
    // Set the base URL for your application
    $locationProvider.html5Mode(true).hashPrefix("");

    // Handle redirects from the old URL to the new URL
    $routeProvider
    .when("/", {
      templateUrl: "/view/search.jsp",
      controller: productCtrl,
    }).when("/home", {
      templateUrl: "/view/search.jsp",
      controller: productCtrl,
    }).when("/blog", {
      templateUrl: "/view/blog.jsp",
      controller: productCtrl,
    }).when("/contact", {
      templateUrl: "./view/contact.jsp",
      controller: productCtrl,
    }).when("/about", {
      templateUrl: "/view/about.jsp",
          controller: productCtrl,
    }).otherwise({
        redirectTo: "/"
    });

});
