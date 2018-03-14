app.controller("UpdateCategoryCtrl", ["CategoryService", "$uibModalInstance", "toastr", "discounts", "category",
    function (CategoryService, $uibModalInstance, toastr, discounts, category) {

        const self = this;

        self.discounts = discounts;
        self.category = category;

        self.updateCategory = (category) => {
            CategoryService.update(category).then(() => {
                toastr.success("Categoria atualizada com sucesso!");
                $uibModalInstance.close(category);
            })
            .catch(() => {
                toastr.error("Problema ao atualizar categoria");
            });;
        }

        self.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }
]);