package funcional;

import asserts.UsuarioAsserts;
import dto.UsuarioRequest;
import factory.UsuarioFactory;
import org.testng.annotations.Test;
import util.BaseTeste;

public class PostUsuariosFuncionalTest extends BaseTeste {

    UsuarioAsserts usuarioAsserts = new UsuarioAsserts();

    @Test
    public void deveRetornarErroAoInformarAdministradorInvalido(){
        UsuarioRequest usuarioRequest = UsuarioFactory.usuarioDinamico("Fulano da Silva", "teste@email.com", "teste", "INVALIDO");
        usuarioAsserts.validaCadastroUsuarioComErroAdministradorInvalido(usuarioRequest);
    }

    @Test
    public void deveRetornarErroAoInformarEmailInvalido(){
        UsuarioRequest usuarioRequest = UsuarioFactory.usuarioDinamico("Fulano da Silva", "test.com", "teste", "true");
        usuarioAsserts.validaCadastroUsuarioComErroEmailInvalido(usuarioRequest);
    }
 }
