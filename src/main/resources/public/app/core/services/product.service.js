app.factory("ProductService", ["$http", "AppConfig", function ($http, AppConfig) {

    const baseServiceUrl = `${AppConfig.baseUrl}/product`;

    function _all() {
        return $http.get(baseServiceUrl);
    }

    function _get(id) {
        return $http.get(`${baseServiceUrl}/${id}`);
    }

    function _update(product) {
        return $http.put(baseServiceUrl, product);
    }

    function _addLot(id, lot) {
        return $http.post(`${baseServiceUrl}/lot/${id}`, lot);
    }

    function _create(produto) {
        return $http.post(baseServiceUrl, produto)
            .then(response => {
                if (response.status === 201) {
                    return response.data;
                }
            });
    }

    function _notifications() {
        return $http.get(`${baseServiceUrl}/notifications`);
    }


    return {
        all: _all,
        update: _update,
        addLot: _addLot,
        create: _create,
        get: _get,
        notifications: _notifications
    };
}]);