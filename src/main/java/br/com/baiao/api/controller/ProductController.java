package br.com.baiao.api.controller;

import br.com.baiao.api.model.Product;
import br.com.baiao.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public void adicionarProduto(@RequestBody Product product){
        productService.salvaProduto(product);
    }

    @GetMapping("")
    public List<Product> retornarTodas(){
        return productService.retornarTodosOsProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>buscarPorId(@PathVariable Long id){
        try {
            Product product = productService.retornarProdutoPorId(id);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable Long id){
        productService.removerProduto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> atualizaProduto(@RequestBody Product product,@PathVariable Long id){
        try{
            productService.retornarProdutoPorId(id);
            product.setId(id);
            productService.salvaProduto(product);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

