/*
 * LinkedIn: https://www.linkedin.com/in/caiohenrks/
 * Github: https://github.com/Caiohenrks
 */
package com.mercadinho.vendas.controller;

import com.mercadinho.vendas.model.Produto;
import com.mercadinho.vendas.model.dto.ProdutoDto;
import com.mercadinho.vendas.repository.ProdutoRepository;
import com.mercadinho.vendas.service.ProdutoService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Caiohenrks
 */
@RequiredArgsConstructor
@RestController
public class ProdutoController {

    public final ProdutoRepository produtoRepository;

    public final ProdutoService produtoService;

    @PostMapping("/produto")
    public ResponseEntity<Produto> salvarProduto(@Valid @RequestBody ProdutoDto produtoDto) {
        produtoService.salvarProduto(produtoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/produtos")
    public ResponseEntity listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long produtoId) {
        Produto produto = produtoService.buscarProdutoPorId(produtoId);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/produto/{produtoId}")
    public ResponseEntity deletarProduto(@PathVariable Long produtoId) {
        Produto produto = produtoService.buscarProdutoPorId(produtoId);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deletarProdutoPorId(produtoId);
        return ResponseEntity.ok().build();
    }

}
