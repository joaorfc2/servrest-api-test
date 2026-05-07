package util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class BaseTeste {

    public static final String BASE_URI = "https://serverest.dev";

    @BeforeClass
    public void configuracaoTeste() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.requestSpecification = new RequestSpecBuilder().setConfig(
                        new RestAssuredConfig()
                                .sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .setContentType(ContentType.JSON)
                .build();

    }
}
