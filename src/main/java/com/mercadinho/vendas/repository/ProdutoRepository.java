/*
 * LinkedIn: https://www.linkedin.com/in/caiohenrks/
 * Github: https://github.com/Caiohenrks
 */
package com.mercadinho.vendas.repository;

import com.mercadinho.vendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  @Caiohenrks
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
