app.controller("AtualizaProdutoCtrl", function ($uibModalInstance, mainService, toastr, produto) {

    const self = this;

    self.produto = produto;

    self.submit = function (product) {
        mainService.atualizaPorId(product.id, product)
            .then(function success(response) {

                if (response.status === 200) {
                    toastr.success("Produto editado com sucesso!");
                    $uibModalInstance.close({
                        status: 200,
                        newProduct: response.data
                    });
                }
            }, function error(error) {
                console.log(error);
                toastr.error("Problemas ao tentar atribuir preço ao produto: " + product.id);
            });

    };

    self.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});