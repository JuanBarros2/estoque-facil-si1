app.controller("AppController", ['$state', 'AuthTokenService', function ($state, authTokenService) {
    const self = this;

    self.isUserAuthenticated = () => {
        return authTokenService.isUserAuthenticated();
    };

    self.logout = () => {
        authTokenService.logout();
        $state.go('home');
    }
}]);