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
                .then(response => {
                    toastr.success("Produto adicionado com sucesso!");
                    vm.product = {};
                    $uibModalInstance.close(201);
                }).catch(error => {
                    console.log(error);
                    toastr.error("Problemas ao tentar adicionar produto.");
                });
        };

        this.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }]);