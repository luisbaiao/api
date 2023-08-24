package br.com.baiao.api.services;

import br.com.baiao.api.model.Category;
import br.com.baiao.api.model.Product;
import br.com.baiao.api.repository.CategoryRepository;
import br.com.baiao.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repositorio;

    @Autowired
    CategoryRepository categoryRepository;
    public List<Product> retornarTodosOsProdutos(){
        return repositorio.findAll();
    }

    public Product retornarProdutoPorId(Long id){
        return repositorio.findById(id).orElseThrow();
    }

    public void salvaProduto(Product produto){
        if (produto.getCategories() !=null){
            List<Category> categoriasAdicionar = new ArrayList<>();
            for(Category category : produto.getCategories()){
                categoriasAdicionar.add(categoryRepository.getReferenceById(category.getId()));
            }
            produto.setCategories(categoriasAdicionar);
        }
        repositorio.save(produto);
    }

    public void removerProduto(Long id){
        repositorio.deleteById(id);
    }
}
