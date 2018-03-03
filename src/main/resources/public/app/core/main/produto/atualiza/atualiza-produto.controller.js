app.controller("UpdateProductCtrl", ["$uibModalInstance", "ProductService", "toastr", "product",
    function ($uibModalInstance, productService, toastr, product) {
        const self = this;

        product.price.toFixed(2);

        self.product = product;

        self.submit = function (product) {
            productService.update(product)
                .then(() => {
                    toastr.success("Produto editado com sucesso!");
                    $uibModalInstance.close({status: 200});
                })
                .catch(function error() {
                    toastr.error("Problemas ao tentar atualizar o produto");
                });
        };

        self.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }]);