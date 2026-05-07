package asserts;

import client.ServRestClient;
import dto.UsuarioRequest;
import dto.UsuarioResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UsuarioAsserts {
    ServRestClient servRestClient = new ServRestClient();
    UsuarioResponse usuarioResponse;

    public void validaCadastroUsuarioComSucesso(UsuarioRequest bodyUsuario) {

        usuarioResponse = servRestClient.postUsuario(bodyUsuario)
                .then()
                .statusCode(201)
                .extract()
                .as(UsuarioResponse.class);

        assertThat(usuarioResponse.getMessage(), containsString("Cadastro realizado com sucesso"));
        assertThat(usuarioResponse.get_id(), is(notNullValue()));
    }

    public void validaCadastroUsuarioComErroAdministradorInvalido(UsuarioRequest bodyUsuario) {

        servRestClient.postUsuario(bodyUsuario)
                .then()
                .statusCode(400)
                .body(containsString("administrador deve ser 'true' ou 'false'"));
    }

    public void validaCadastroUsuarioComErroEmailInvalido(UsuarioRequest bodyUsuario) {

        servRestClient.postUsuario(bodyUsuario)
                .then()
                .statusCode(400)
                .body(containsString("email deve ser um email válido"));

    }

    public void validaCadastroUsuarioComErroEmailJaExistente(UsuarioRequest bodyUsuario) {

        servRestClient.postUsuario(bodyUsuario)
                .then()
                .statusCode(400)
                .body(containsString("Este email já está sendo usado"));

        assertThat(usuarioResponse.getMessage(), containsString("Este email já está sendo usado"));
    }
}
