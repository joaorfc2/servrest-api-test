package aceitacao;

import asserts.UsuarioAsserts;
import factory.UsuarioFactory;
import dto.UsuarioRequest;
import org.testng.annotations.Test;
import util.BaseTeste;

public class PostUsuariosAceitacaoTest extends BaseTeste {
    UsuarioAsserts usuarioAsserts = new UsuarioAsserts();

    @Test
    public void deveCadastrarUsuarioAdministradorComSucesso(){
        UsuarioRequest usuarioRequest = UsuarioFactory.usuarioComSucesso("true");
        usuarioAsserts.validaCadastroUsuarioComSucesso(usuarioRequest);
    }

    @Test
    public void deveCadastrarUsuarioComumComSucesso(){
        UsuarioRequest usuarioRequest = UsuarioFactory.usuarioComSucesso("false");
        usuarioAsserts.validaCadastroUsuarioComSucesso(usuarioRequest);
    }
}
