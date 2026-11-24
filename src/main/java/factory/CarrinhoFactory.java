package factory;

import dto.CarrinhoRequest;
import dto.ProdutoCarrinhoRequest;

import java.util.Arrays;

public class CarrinhoFactory {

    public static CarrinhoRequest carrinhoComSucesso() {
        return CarrinhoRequest.builder()
                .produtos(Arrays.asList(
                        ProdutoCarrinhoRequest.builder()
                                .idProduto("BeeJh5lz3k6kSIzA")
                                .quantidade(1)
                                .build(),
                        ProdutoCarrinhoRequest.builder()
                                .idProduto("K6leHdftCeOJj8BJ")
                                .quantidade(3)
                                .build()))
                .build();
    }
}
