package aceitacao;

import asserts.LoginAsserts;
import constants.Constantes;
import factory.LoginFactory;
import dto.LoginRequest;
import org.testng.annotations.Test;
import util.BaseTeste;

public class PostLoginAceitacaoTest extends BaseTeste {
    LoginAsserts loginAsserts = new LoginAsserts();

    @Test
    public void deveRealizarLoginComSucesso(){
        LoginRequest loginRequest = LoginFactory.loginBodySucesso(Constantes.emailValido, Constantes.senhaValida);
        loginAsserts.validaLoginComSucesso(loginRequest);
    }
}
