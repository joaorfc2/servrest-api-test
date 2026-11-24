package aceitacao;

import asserts.CarrinhoAsserts;
import constants.Constantes;
import dto.CarrinhoRequest;
import dto.LoginRequest;
import factory.CarrinhoFactory;
import factory.LoginFactory;
import org.testng.annotations.Test;
import util.BaseTeste;

public class PostCarrinhoAceitacaoTest extends BaseTeste {

    private final CarrinhoAsserts carrinhoAsserts = new CarrinhoAsserts();

    @Test
    public void deveCadastrarCarrinhoComSucesso() {
        LoginRequest loginRequest = LoginFactory.loginBodySucesso(Constantes.emailValido, Constantes.senhaValida);
        CarrinhoRequest carrinhoRequest = CarrinhoFactory.carrinhoComSucesso();

        carrinhoAsserts.validaCadastroCarrinhoComSucesso(loginRequest, carrinhoRequest);
    }
}
