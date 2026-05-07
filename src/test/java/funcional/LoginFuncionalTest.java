package funcional;

import asserts.LoginAsserts;
import dto.LoginRequest;
import factory.LoginFactory;
import org.testng.annotations.Test;
import util.BaseTeste;

public class LoginFuncionalTest extends BaseTeste {

    LoginAsserts loginAsserts = new LoginAsserts();

    @Test
    public void deveRealizarLoginComErro(){
        LoginRequest loginRequest = LoginFactory.loginBodySucesso("erroemail@teste.com", "erro1");
        loginAsserts.validaLoginComErro(loginRequest);
    }
}
