app.service('AuthApiService', ["$http", 'AuthTokenService', "AppConfig", function($http, authTokenService, AppConfig) {
    const self = this;

    const authUrl = `${AppConfig.baseUrl}/auth/login`;

    self.loga = (credenciais) => {
        return new Promise((resolve, reject) => {
            $http.post(authUrl, credenciais).then((resposta) => {
                authTokenService.setToken(resposta.data['Authorization']);
                resolve(resposta);
            }).catch((error) => {
                reject(error);
            });
        })
    };
}]);