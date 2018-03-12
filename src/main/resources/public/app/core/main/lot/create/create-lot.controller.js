app.controller("CreateLotCtrl", ["ProductService", "$uibModalInstance", "toastr", "product",
    function (productService, $uibModalInstance, toastr, product) {

        const self = this;

        self.datePicker = {
            open: false,
            dateOptions: {
                formatYear: 'yy',
                startingDay: 1
            },
            minDate: new Date(),
            dateformat: 'dd/MM/yyyy'
        };

        self.addLot = function (lot) {
            lot = angular.copy(lot);

            lot.expirationDate = lot.expirationDate.getDay() + "/" +
                (lot.expirationDate.getMonth() + 1) + "/" +
                lot.expirationDate.getFullYear();

            productService.addLot(product.id, JSON.stringify(lot))
                .then(() => {
                    toastr.success("Lote criado com sucesso!");
                    $uibModalInstance.close({status: 201});
                })
                .catch(() => {
                    toastr.error("Problemas ao tentar adicionar o lote.");
                });
        };

        self.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };

        self.openDatePicker = function () {
            self.datePicker.open = true;
        }
    }]);