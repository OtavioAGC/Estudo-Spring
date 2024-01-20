package com.aprendendo.inicio.spring.repository;

import com.aprendendo.inicio.spring.entites.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    @Query(value = "select * from Produto where id_produto = :id", nativeQuery = true)
    Produto getById(@Param("id") Long id);

    @Query(value = "select * from Produto where nome = :nome", nativeQuery = true)
    Produto getByName(@Param("nome") String nome);
}
