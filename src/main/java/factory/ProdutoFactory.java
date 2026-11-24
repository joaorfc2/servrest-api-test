package factory;

import dto.ProdutoRequest;

import java.util.UUID;

public class ProdutoFactory {

    public static ProdutoRequest produtoComSucesso() {
        return ProdutoRequest.builder()
                .nome("Logitech MX Vertical " + UUID.randomUUID())
                .preco(470)
                .descricao("Mouse")
                .quantidade(381)
                .build();
    }
}
