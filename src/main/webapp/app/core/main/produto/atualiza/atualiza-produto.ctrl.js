app.controller("AtualizaProdutoCtrl", function ($scope, $uibModalInstance, mainService, toastr, produto) {

    $scope.produto = produto;

    $scope.submit = function (product) {
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

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});