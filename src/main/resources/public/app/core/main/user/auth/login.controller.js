app.controller('LoginCtrl', ['$state', 'toastr', 'AuthApiService', function($state, toastr, authService) {
    const self = this;

    self.errorMessage = {mustShow: false};

    self.loga = (credencials) => {
        authService.loga(credencials).then(() => {
            $state.go('product');
        }).catch((error) => {
            toastr.error(error);
        });
    }
}]);