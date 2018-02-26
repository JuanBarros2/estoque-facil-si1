app.factory("ProdutoService", ["$http", "AppConfig", function ($http, AppConfig) {

    const baseServiceUrl = `${AppConfig.baseUrl}/produto`;

    function _todos() {
        return $http.get(baseServiceUrl);
    }

    function _atualizaPorId(id, data) {
        return $http.put(`${baseServiceUrl}/${id}`, data);
    }

    function _pesquisaPorId(id) {
        return $http.get(`${baseServiceUrl}/${id}`);
    }

    function _cria(produto) {
        $http.post(`${baseServiceUrl}/`, produto);
    }

    return {
        todos: _todos,
        atualizaPorId: _atualizaPorId,
        pesquisaPorId: _pesquisaPorId,
        cria: _cria
    };
}]);