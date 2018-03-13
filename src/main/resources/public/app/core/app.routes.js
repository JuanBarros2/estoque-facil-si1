app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider

        .state("home", {
            url: "/",
            templateUrl: "app/core/main/user/auth/loga.html",
            controller: 'LogaCtrl',
            controllerAs: "logaCtrl"
        })

        .state("products", {
            url: "/produto",
            templateUrl: "app/core/main/produto/search/search-product.html",
            controller: "SearchProductCtrl",
            controllerAs: "searchProductCtrl"
        })

        .state("categories", {
            url: "/categoria",
            templateUrl: "app/core/main/category/search/search-category.html"
        })

        .state("sales", {
            url: "/vendas",
            templateUrl: "app/core/main/sale/search/search-sale.html"
        })
});