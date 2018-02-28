app.controller("CriaLoteCtrl", function (ProdutoLoteService, $uibModalInstance, $http, toastr, produto) {

    const self = this;

    self.produto = produto;
    self.dateformat = 'dd/MM/yyyy';
    self.datePicker = {
        opened : false
    };

    self.dataDeValidade = new Date();
    self.numeroDeItens = 0;

    self.dateOptions = {
        formatYear: 'yy',
        minDate: new Date(),
        startingDay: 1
    };

    self.submit = function (dataDeValidade, numeroDeItens) {

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

    self.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };

    self.openDatePicker = function () {
        self.datePicker.opened = true;
    }
});