package com.aprendendo.inicio.spring.controller;

import com.aprendendo.inicio.spring.entites.Produto;
import com.aprendendo.inicio.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto produtoCadastrado = produtoService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> produtoList = produtoService.getAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Produto> getById(@RequestParam Long id) {
        Produto produto = produtoService.getById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produto);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> getById(@RequestParam String nome) {
        Produto produto = produtoService.getByName(nome);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduto(@RequestParam Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Produto> putProduto(@RequestBody Produto produto, @RequestParam Long id) {
        Produto produtoAtualizado = produtoService.updateProduto(produto,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoAtualizado);
    }

}

// localhost:8080/produto/all
// localhost:8080/produto/1
// stauts 200 OK
// not found 404

// DEV - HML - PRD