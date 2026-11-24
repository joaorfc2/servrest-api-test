package asserts;

import client.ServRestClient;
import dto.CarrinhoRequest;
import dto.CarrinhoResponse;
import dto.LoginRequest;
import dto.LoginResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CarrinhoAsserts {

    private final ServRestClient servRestClient = new ServRestClient();
    private final LoginAsserts loginAsserts = new LoginAsserts();

    public void validaCadastroCarrinhoComSucesso(LoginRequest bodyLogin, CarrinhoRequest bodyCarrinho) {
        LoginResponse loginResponse = loginAsserts.validaLoginComSucesso(bodyLogin);
        servRestClient.deleteConcluirCompra(loginResponse.getAuthorization())
                .then()
                .statusCode(200);

        CarrinhoResponse carrinhoResponse = servRestClient.postCarrinho(bodyCarrinho, loginResponse.getAuthorization())
                .then()
                .statusCode(201)
                .extract()
                .as(CarrinhoResponse.class);

        assertThat(carrinhoResponse.getMessage(), containsString("Cadastro realizado com sucesso"));
        assertThat(carrinhoResponse.get_id(), is(notNullValue()));
    }
}
