app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider

        .state("home", {
            url: "/",
            templateUrl: "app/core/main/usuario/auth/loga.html",
            controller: 'LogaCtrl',
            controllerAs: "logaCtrl"
        })

        .state("produto", {
            url: "/produto",
            templateUrl: "app/core/main/produto/pesquisa/pesquisa-produto.html",
            controller: "PesquisaProdutoCtrl",
            controllerAs: "pesquisaProdutoCtrl"
        })
});