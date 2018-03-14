app.service('SaleService', ["$http", "AppConfig", function($http, AppConfig) {
    const self = this;

    const baseUrl = `${AppConfig.baseUrl}/sale`;

    self.add = (sale) => {
        return $http.post(baseUrl, sale);
    };
}]);