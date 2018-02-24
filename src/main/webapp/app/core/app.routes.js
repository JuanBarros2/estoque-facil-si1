app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider
        .state("home", {
            url: "/",
            templateUrl: "app/core/main/produto/pesquisa/search-product.html",
            controller: "PesquisaProdutoCtrl"
        })

        .state("home.login", {
            url: "login",
            templateUrl: "app/components/user/login/login.html",
            controller: 'LoginCtrl',
            controllerAs: "vm"
        })
});
