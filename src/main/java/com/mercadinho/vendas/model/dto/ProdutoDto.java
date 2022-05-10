/*
 * LinkedIn: https://www.linkedin.com/in/caiohenrks/
 * Github: https://github.com/Caiohenrks
 */
package com.mercadinho.vendas.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 * @Caiohenrks
 */
@Getter
public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private float preco;
}
