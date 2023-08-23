package br.com.baiao.api.repository;

import br.com.baiao.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}