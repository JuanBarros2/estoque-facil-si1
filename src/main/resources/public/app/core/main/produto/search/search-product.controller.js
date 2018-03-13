app.controller("SearchProductCtrl", ["$uibModal", "$http", "toastr", "ProductService",
    function ($uibModal, $http, toastr, productService) {

        const self = this;

        self.productsList = [];
        self.produtos = [];

        const loadProductsList = function () {
            productService.all()
                .then(response => {
                    self.productsList = response.data
                })
                .catch(() => {
                    toastr.error("Problema ao carregar lista de produtos");
                });
        };

        self.openCreateProductDialog = function () {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Adicionar Produto',
                ariaDescribedBy: 'Formulario para adição de um novo produto',
                templateUrl: 'app/core/main/produto/create/create-product.html',
                controller: 'CreateProductCtrl',
                controllerAs: 'cpCtrl'
            });

            modalInstance.result.then(function (result) {
                if (result === 201) {
                    loadProductsList();
                }
            });
        };

        self.updateProduct = function (product) {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Atribuir preço a Produto',
                ariaDescribedBy: 'Formulario para Atribuir preço a Produto',
                templateUrl: 'app/core/main/produto/update/atualiza-produto.html',
                controller: 'UpdateProductCtrl',
                controllerAs: 'updProdCtrl',
                resolve: {
                    product: () => productService.get(product.id).then(response => response.data)
                }
            });

            modalInstance.result.then(function (result) {
                if (result.status === 200) {
                    loadProductsList();
                }
            });
        };

        self.createLote = function (product) {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Criar lote',
                ariaDescribedBy: 'Formulario para criar lote',
                templateUrl: 'app/core/main/lot/create/create-lot.html',
                controller: 'CreateLotCtrl',
                controllerAs: 'createLotCtrl',
                resolve: {
                    product: () => angular.copy(product)
                }
            });

            modalInstance.result.then(function (result) {
                if (result.status === 201) {
                    loadProductsList();
                }
            });
        };

        loadProductsList();
    }
]);