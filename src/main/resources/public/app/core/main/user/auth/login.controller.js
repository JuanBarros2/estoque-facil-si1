app.controller('LoginCtrl', ['$state', 'toastr', 'AuthApiService', function($state, toastr, authService) {
    const self = this;

    self.errorMessage = {mustShow: false};

    self.loga = (credenciais) => {
        authService.loga(credenciais).then(() => {
            $state.go('product');
        }).catch((error) => {
            toastr.error(error);
        });
    }
}]);