package br.com.baiao.api.services;

import br.com.baiao.api.model.Category;
import br.com.baiao.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repositorio;

    public List<Category> retornarTodasAsCategorias(){
        return repositorio.findAll();
    }
    public Category retornarCategoriaPorId(Long id){
        return repositorio.findById(id).orElseThrow();
    }
    public void salvarCategoria(Category categoria){
        repositorio.save(categoria);
    }

    public void removerCategoria(Long id){
        repositorio.deleteById(id);
    }

}

