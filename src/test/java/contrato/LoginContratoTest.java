package contrato;

import factory.LoginFactory;
import org.testng.annotations.Test;
import dto.LoginRequest;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class LoginContratoTest {

    @Test
    public void validarContratoLogin() {
        String baseUrl = "https://serverest.dev";
        LoginRequest loginRequest = LoginFactory.loginBodySucesso("fulano@qa.com", "teste");

        given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(loginRequest)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(
                        new File("src/test/resources/jsonSchemas/login-schema.json")));
    }

}
