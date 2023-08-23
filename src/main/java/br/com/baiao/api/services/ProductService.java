package br.com.baiao.api.services;

import br.com.baiao.api.model.Product;
import br.com.baiao.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repositorio;

    public List<Product> retornarTodosOsProdutos(){
        return repositorio.findAll();
    }

    public Product retornarProdutoPorId(Long id){
        return repositorio.findById(id).orElseThrow();
    }

    public void salvaProduto(Product produto){
        repositorio.save(produto);
    }

    public void removerProduto(Long id){
        repositorio.deleteById(id);
    }
}
