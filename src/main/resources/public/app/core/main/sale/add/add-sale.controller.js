app.controller("AddSaleCtrl", ["toastr", "$uibModalInstance", "ProductService", "SaleService",
    function (toastr, $uibModalInstance, productService, saleService) {
        const self = this;

        productService.all().then((response) => {
            const products = response.data;
            _buildItensList(products);
        });

        self.addItem = (sale, item) => {
            sale = _buildSaleIfNeeded(sale);
            item.price = item.product.price * item.amount;
            sale.items.push(item);
            sale.totalPrice += item.price;
            _updateItensAdd(item);
        };

        const _updateItensAdd = (item) => {
            if (!self.itensInSale) self.itensInSale = [];
            self.itensInSale.push(item);
            self.itensOutSale =
                self.itensOutSale.filter(e => e.product.id !== item.product.id);
        };

        const _buildSaleIfNeeded = (sale) => {
            if (!sale) {
                self.sale = {
                    items: [],
                    totalPrice: 0
                }
            }
            return self.sale;
        };

        self.removeItem = (sale, item) => {
            sale.items = sale.items.filter(e => e.product.id !== item.product.id);
            sale.totalPrice -= item.price;
            _updateItensRemove(item)
        };

        const _updateItensRemove = (saleItem) => {
            self.itensOutSale.push(saleItem);
            self.itensInSale =
                self.itensInSale.filter(e => e.product.id !== saleItem.product.id);
        };

        self.addSale = (sale) => {
            saleService.add(sale).then(() => {
                $uibModalInstance.close(201);
            }).catch( () => {
                $uibModalInstance.close(500);
            });
        };

        const _buildItensList = (products) => {
            self.itensOutSale = products.map(p => {
                if(p.amount)
                    return {product: p};
            }).filter(p => !!p);
        };

        self.cancel = () => {
            $uibModalInstance.dismiss();
        };
    }]);