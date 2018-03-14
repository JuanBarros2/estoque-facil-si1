app.factory("CategoryService", ["$http", "AppConfig", function ($http, AppConfig) {

    const baseServiceUrl = `${AppConfig.baseUrl}/category`;

    function _all() {
        return $http.get(baseServiceUrl).then(response => response.data);
    }

    function _update(category) {
        return $http.put(baseServiceUrl, category);
    }

    return {
        all: _all,
        update: _update
    };
}]);