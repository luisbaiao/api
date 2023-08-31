package br.com.baiao.api.controller;


import br.com.baiao.api.model.Category;
import br.com.baiao.api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //adicionarCategoria
    @PostMapping("/")
    public void adicionarCategoria(@RequestBody Category  category){
        categoryService.salvarCategoria(category);
    }


    //retornarTodas
    @GetMapping("")
    public List<Category> retornarTodas(){
        return categoryService.retornarTodasAsCategorias();
    }


    //Retornar Por ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> buscarPorid(@PathVariable Long id){
        try {
            Category category = categoryService.retornarCategoriaPorId(id);
            return new ResponseEntity<>(category,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //removerCategoria

    @DeleteMapping("/{id}")
    public void removerCategoria(@PathVariable Long id){
        categoryService.removerCategoria(id);
    }

    //Atualiza Categoria

    @PutMapping("/{id}")
    public ResponseEntity<Category>atualizaCategoria(@RequestBody Category category, @PathVariable Long id){
        try {
            categoryService.retornarCategoriaPorId(id);
            category.setId(id);
            categoryService.salvarCategoria(category);
            return new ResponseEntity<>(category,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
