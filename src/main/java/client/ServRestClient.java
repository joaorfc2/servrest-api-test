package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import dto.CarrinhoRequest;
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

    public Response postCarrinho(CarrinhoRequest carrinhoBody, String authorization){

        return given()
                .spec(requestSpecification)
                .header("Authorization", authorization)
                .body(carrinhoBody)
                .when()
                .post("/carrinhos");
    }

    public Response deleteConcluirCompra(String authorization){

        return given()
                .spec(requestSpecification)
                .header("Authorization", authorization)
                .accept(ContentType.JSON)
                .when()
                .delete("/carrinhos/concluir-compra");
    }
}
