package client;

import io.restassured.response.Response;
import dto.LoginRequest;
import dto.ProdutoRequest;
import dto.UsuarioRequest;
import util.BaseTeste;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ServRestClient extends BaseTeste {

    public Response postLogin(LoginRequest loginBody){

        return given()
                .spec(requestSpecification)
                .body(loginBody)
                .when()
                .post("/login");
    }

    public Response postUsuario(UsuarioRequest usuarioBody){

        return given()
                .spec(requestSpecification)
                .body(usuarioBody)
                .when()
                .post("/usuarios");
    }

    public Response postProduto(ProdutoRequest produtoBody, String authorization){

        return given()
                .spec(requestSpecification)
                .header("Authorization", authorization)
                .body(produtoBody)
                .when()
                .post("/produtos");
    }
}
