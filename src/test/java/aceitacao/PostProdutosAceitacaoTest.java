package aceitacao;

import asserts.ProdutoAsserts;
import constants.Constantes;
import dto.LoginRequest;
import dto.ProdutoRequest;
import factory.LoginFactory;
import factory.ProdutoFactory;
import org.testng.annotations.Test;
import util.BaseTeste;

public class PostProdutosAceitacaoTest extends BaseTeste {

    private final ProdutoAsserts produtoAsserts = new ProdutoAsserts();

    @Test
    public void deveCadastrarProdutoComSucesso() {
        LoginRequest loginRequest = LoginFactory.loginBodySucesso(Constantes.emailValido, Constantes.senhaValida);
        ProdutoRequest produtoRequest = ProdutoFactory.produtoComSucesso();

        produtoAsserts.validaCadastroProdutoComSucesso(loginRequest, produtoRequest);
    }
}
