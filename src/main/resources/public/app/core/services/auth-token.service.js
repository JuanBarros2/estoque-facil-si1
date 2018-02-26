app.service('AuthTokenService', ['$localStorage', function ($localStorage) {
    const self = this;

    self.getAuthHeaderValue = () => $localStorage.token;

    self.isUserAuthenticated = () => !!$localStorage.token;

    self.logout = () => {
        $localStorage.token = null;
    };

    self.setToken = (token) => {
        $localStorage.token = token;
    }
}]);
