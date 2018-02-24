app.controller("CriaProdutoCtrl", ["$uibModalInstance", "$http", "toastr", "ProdutoService",
    function ($uibModalInstance, $http, toastr, produtoService) {

        const vm = this;

        vm.product = {};

        vm.listaDeSituacoes = [
            {
                nome: "Disponivel",
                valor: 1
            }, {
                nome: "Em Falta",
                valor: 2
            }
        ];

        this.createProduct = function (product) {

            // if (situacao) {
            //     if (situacao === 1) {
            //         product.situacao = 1
            //     } else {
            //         product.situacao = 2
            //     }
            // }

            // product.situacao = situacao === 1 ? 1 : 2;

            produtoService.cria(JSON.stringify(product))
                .then(function success(response) {
                    if (response.status === 201) {
                        toastr.success("Produto adicionado com sucesso!");
                        vm.product = {};
                        console.log(response)
                        $uibModalInstance.close(201);
                    }
                }, function error(error) {
                    console.log(error);
                    toastr.error("Problemas ao tentar adicionar produto.");
                });
        };

        this.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }]);