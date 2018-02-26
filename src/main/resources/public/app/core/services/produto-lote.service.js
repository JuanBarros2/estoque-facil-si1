app.factory("ProdutoLoteService", ["$http", "AppConfig", function ($http, AppConfig) {

    const baseServiceUrl = `${AppConfig.baseUrl}/produto`;

    function _cria(idProduto, lote) {
        $http.post(`${baseServiceUrl}/${idProduto}/lote`, produto)
            .then(response => {
                console.log(response)
                if (response.status === 201) {
                    return response.data;
                }
            });
    }

    return {
        cria: _cria
    };
}]);