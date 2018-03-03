app.controller("CreateProductCtrl", ["$uibModalInstance", "$http", "toastr", "ProductService",
    function ($uibModalInstance, $http, toastr, produtoService) {
        const self = this;

        self.createProduct = function (product) {
            product.category.name = product.category.name.toLowerCase();

            produtoService.create(JSON.stringify(product))
                .then(() => {
                    toastr.success("Produto adicionado com sucesso!");
                    $uibModalInstance.close(201);
                })
                .catch(() => {
                    toastr.error("Produto já cadastrado");
                });
        };

        self.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }]);