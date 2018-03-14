app.controller("CategoryCtrl", ["categories", "$uibModal",
    function (categories, $uibModal) {

        const self = this;
        self.categories = categories;

        self.discounts = {
            0: "Sem desconto",
            10: "Bom desconto (10%)",
            25: "Ótimo desconto (25%)",
            50: "Super desconto (50%)"
        }

        self.openUpdateCategoryDialog = (category) => {
            const modalInstance = $uibModal.open({
                ariaLabelledBy: 'Alterar desconto',
                ariaDescribedBy: 'Formulario para alteração do desconto aplicado à categoria',
                templateUrl: 'app/core/main/category/update/update-category.html',
                controller: 'UpdateCategoryCtrl',
                controllerAs: 'updtCategoryCtrl',
                resolve: {
                    discounts: () => self.discounts,
                    category: () => angular.copy(category)
                }
            });

            modalInstance.result.then(result => {
                category.discount = result.discount;
            });
        };
        
    }
]);