app.controller("SearchSaleCtrl", ["toastr", "$uibModal", "SaleService",
    function (toastr, $uibModal, salesService) {
        const self = this;

        const _loadSales = () => {
            salesService.all().then(response => {
                self.sales = response.data;
            })
        };

        _loadSales();

        self.addSale = () => {
            const modalInstance = $uibModal.open({
                templateUrl: 'app/core/main/sale/add/add-sale.html',
                controller: 'AddSaleCtrl',
                controllerAs: 'addSaleCtrl'
            });

            modalInstance.result.then(function (result) {
                console.log(result);
                if (result === 201) {
                    toastr.show("Venda adicionada");
                    _loadSales();
                } else if (result === 500) {
                    toastr.error("Erro ao concluir venda");
                }
            });
        };

        self.orderBy = (orderingCriteria) => {
            self.salesOrderCriteria = orderingCriteria;
            self.orderDirection = !self.orderDirection;
        }
    }]);