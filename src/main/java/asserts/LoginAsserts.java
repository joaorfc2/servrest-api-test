package asserts;

import client.ServRestClient;
import dto.LoginRequest;
import dto.LoginResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginAsserts {
    ServRestClient servRestClient = new ServRestClient();
    LoginResponse loginResponse;

    public void validaLoginComSucesso(LoginRequest bodyLogin) {

        loginResponse = servRestClient.postLogin(bodyLogin).
                then()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);

        assertThat(loginResponse.getMessage(), containsString("Login realizado com sucesso"));
        assertThat(loginResponse.getAuthorization(), is(notNullValue()));

    }

    public void validaLoginComErro(LoginRequest bodyLogin) {

        loginResponse = servRestClient.postLogin(bodyLogin).
                then()
                .statusCode(401)
                .extract()
                .as(LoginResponse.class);

        assertThat(loginResponse.getMessage(), containsString("Email e/ou senha inválidos"));
    }
}
