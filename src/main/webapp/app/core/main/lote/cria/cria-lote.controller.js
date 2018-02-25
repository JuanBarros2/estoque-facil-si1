app.controller("CriaLoteCtr", function ($scope, ProdutoLoteService, $uibModalInstance, $http, toastr, produto) {

    $scope.produto = produto;
    $scope.dateformat = 'dd/MM/yyyy';
    $scope.datePicker = {
        opened : false
    };

    $scope.dataDeValidade = new Date();
    $scope.numeroDeItens = 0;

    $scope.dateOptions = {
        formatYear: 'yy',
        minDate: new Date(),
        startingDay: 1
    };

    $scope.submit = function (dataDeValidade, numeroDeItens) {

        //adicionar
        var lote = {
            dataDeValidade: dataDeValidade.getDay() + "/" + (dataDeValidade.getMonth() + 1) + dataDeValidade.getFullYear(),
            numeroDeItens: numeroDeItens
        }

        ProdutoLoteService.cria(produto.id, JSON.stringify(lote))
            .then(response => {
                console.log("Lote criado com sucesso!");
                toastr.success("Lote criado com sucesso!");
                $uibModalInstance.close({
                    status: 201
                });
            }, error => {
                console.log(error);
                toastr.error("Problemas ao tentar adicionar produto.");
            });
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };

    $scope.openDatePicker = function () {
        $scope.datePicker.opened = true;
    }
});