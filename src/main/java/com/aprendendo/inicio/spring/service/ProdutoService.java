package com.aprendendo.inicio.spring.service;

import com.aprendendo.inicio.spring.entites.Produto;
import com.aprendendo.inicio.spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepository.getById(id);
    }

    public Produto getByName(String nome) {
        try {

            return produtoRepository.getByName(nome);

        } catch (Exception ex) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "nao encontrado com este nome: " + nome);

        }
    }

    public void deleteProduto(Long id) {
        Produto produto = getById(id);
        produtoRepository.delete(produto);
    }

    public Produto updateProduto(Produto produtoNovo, Long id) {
        Produto produto = getById(id);

        produto.setNome(produtoNovo.getNome());
        produto.setMarca(produtoNovo.getMarca());
        produto.setValidade(produtoNovo.getValidade());

        return produtoRepository.save(produto);
    }
}
