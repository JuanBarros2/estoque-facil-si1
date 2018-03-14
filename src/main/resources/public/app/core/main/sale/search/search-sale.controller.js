app.controller("SearchSaleCtrl", ["toastr", "$uibModal",
    function (toastr, $uibModal) {
        const self = this;

        self.addSale = () => {
            const modalInstance = $uibModal.open({
                templateUrl: 'app/core/main/sale/add/add-sale.html',
                controller: 'AddSaleCtrl',
                controllerAs: 'addSaleCtrl'
            });

            modalInstance.result.then(function (result) {
                console.log(result);
                if (result === 201) {
                    //todo load sales
                    toastr.show("Venda adicionada");
                }
            });
        }
    }]);