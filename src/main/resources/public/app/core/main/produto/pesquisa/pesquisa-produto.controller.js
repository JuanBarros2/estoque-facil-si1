app.controller("PesquisaProdutoCtrl", ["$uibModal", "$http", "toastr", "ProdutoService",
    function ($uibModal, $http, toastr, produtoService) {

        const self = this;

        self.productsList = [];
        self.produtos = [];

        const loadProductsList = function () {
            produtoService.todos()
                .then(response => {
                    self.productsList = response.data
                })
                .catch(error => {
                    console.log(error);
                });
        };

        self.openCreateProductDialog = function () {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Adicionar Produto',
                ariaDescribedBy: 'Formulario para adição de um novo produto',
                templateUrl: 'app/core/main/produto/cria/cria-produto.html',
                controller: 'CriaProdutoCtrl',
                controllerAs: 'cpCtrl'
            });

            modalInstance.result.then(function (result) {
                if (result === 201) {
                    loadProductsList();
                }
            });
        };

        self.openAtribuirPrecoParaProdutoDialog = function (product) {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Atribuir preço a Produto',
                ariaDescribedBy: 'Formulario para Atribuir preço a Produto',
                templateUrl: 'app/core/main/atualiza-produto.html',
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

        self.pesquisarProdutoPorId = function (id) {
            // implementar
            produtoService.pesquisaPorId(id)
                .then(response => {
                    self.productsList = [
                        response.data
                    ];
                }).catch(error => {
                    toastr.error("Produto não encontrado");
                });
        };

        self.openCriarLoteDialog = function (product) {
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

        self.getLotsById = function (id) {
            return produtoService.getLotsByIdId(id).data;
        }

        loadProductsList();
        loadProductsList();
    }
]);