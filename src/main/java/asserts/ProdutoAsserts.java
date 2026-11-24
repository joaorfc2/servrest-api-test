package asserts;

import client.ServRestClient;
import dto.LoginRequest;
import dto.LoginResponse;
import dto.ProdutoRequest;
import dto.ProdutoResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProdutoAsserts {

    private final ServRestClient servRestClient = new ServRestClient();
    private final LoginAsserts loginAsserts = new LoginAsserts();

    public void validaCadastroProdutoComSucesso(LoginRequest bodyLogin, ProdutoRequest bodyProduto) {
        LoginResponse loginResponse = loginAsserts.validaLoginComSucesso(bodyLogin);

        ProdutoResponse produtoResponse = servRestClient.postProduto(bodyProduto, loginResponse.getAuthorization())
                .then()
                .statusCode(201)
                .extract()
                .as(ProdutoResponse.class);

        assertThat(produtoResponse.getMessage(), containsString("Cadastro realizado com sucesso"));
        assertThat(produtoResponse.get_id(), is(notNullValue()));
    }
}
