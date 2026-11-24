package dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoRequest {

    String nome;
    Integer preco;
    String descricao;
    Integer quantidade;
}
