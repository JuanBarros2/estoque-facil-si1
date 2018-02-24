app.controller("PesquisaProdutoCtrl", ["$scope", "$uibModal", "$http", "toastr", "ProdutoService",
    function ($scope, $uibModal, $http, toastr, produtoService) {
        $scope.productsList = [];
        $scope.produtos = [];

        const loadProductsList = function () {
            produtoService.todos()
                .then(response => {
                    $scope.productsList = response.data
                })
                .catch(error => {
                    console.log(error);
                });
        };

        $scope.openCreateProductDialog = function () {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Adicionar Produto',
                ariaDescribedBy: 'Formulario para adição de um novo produto',
                templateUrl: 'app/core/main/produto/cria/create-product.html',
                controller: 'CriaProdutoCtrl',
                controllerAs: 'cpCtrl'
            });

            modalInstance.result.then(function (result) {
                if (result === 201) {
                    loadProductsList();
                }
            });
        };

        $scope.openAtribuirPrecoParaProdutoDialog = function (product) {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Atribuir preço á Produto',
                ariaDescribedBy: 'Formulario para Atribuir preço á Produto',
                templateUrl: 'app/core/main/updateProductPriceView.html',
                controller: 'UpdateProductPriceCtrl',
                resolve: {
                    produto: function () {
                        return angular.copy(product);
                    }
                }
            });

            modalInstance.result.then(function (result) {
                if (result.status === 200) {
                    loadProductsList();
                }
            });
        };

        $scope.pesquisarProdutoPorId = function (id) {
            // implementar
            produtoService.pesquisaPorId(id)
                .then(function successCallback(response) {
                    $scope.productsList = [
                        response.data
                    ];
                }, function errorCallback(error) {
                    toastr.error("Produto não encontrado");
                });
        };

        $scope.openCriarLoteDialog = function (product) {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Criar lote',
                ariaDescribedBy: 'Formulario para criar lote',
                templateUrl: 'app/core/main/createLoteView.html',
                controller: 'CriarLoteCtrl',
                resolve: {
                    produto: function () {
                        return angular.copy(product);
                    }
                }
            });

            modalInstance.result.then(function (result) {
                if (result.status === 201) {
                    loadProductsList();
                }
            });
        };

        loadProductsList();
        loadProductsList();
    }
]);