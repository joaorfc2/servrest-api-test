package factory;

import dto.UsuarioRequest;
import util.GeradorDados;

public class UsuarioFactory {

    public static UsuarioRequest usuarioComSucesso(String administrador) {
        return UsuarioRequest.builder()
                .nome("Administrador Teste")
                .email(GeradorDados.gerarEmailUnico())
                .password(GeradorDados.gerarSenha10Digitos())
                .administrador(administrador)
                .build();
    }

    public static UsuarioRequest usuarioDinamico(String nome, String email, String password, String administrador) {
        return UsuarioRequest.builder()
                .nome(nome)
                .email(email)
                .password(password)
                .administrador(administrador)
                .build();
    }
    }
