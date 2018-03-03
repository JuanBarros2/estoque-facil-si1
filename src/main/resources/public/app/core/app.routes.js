app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider

        .state("home", {
            url: "/",
            templateUrl: "app/core/main/user/auth/loga.html",
            controller: 'LogaCtrl',
            controllerAs: "logaCtrl"
        })

        .state("produto", {
            url: "/produto",
            templateUrl: "app/core/main/produto/search/search-product.html",
            controller: "SearchProductCtrl",
            controllerAs: "searchProductCtrl"
        })
});