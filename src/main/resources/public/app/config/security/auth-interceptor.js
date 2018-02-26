app.factory('AuthInterceptor', ['$location', "AuthTokenService", function($location, AuthTokenService, $q) {
    return {
        request: function (config) {
            config.headers = config.headers || {};

            if (AuthTokenService.getAuthHeaderValue()) {
                config.headers['Authorization'] = AuthTokenService.getAuthHeaderValue();
            }

            return config;
        },

        responseError: function (response) {
            if (response.status === 401 || response.status === 403) {
                $location.path('/');
            }
            return $q.reject(response);
        }
    }
}]).config(($httpProvider) => {
    $httpProvider.interceptors.push('AuthInterceptor');
});