package com.sample.app.DemoSpringBootApp.dao;

import com.sample.app.DemoSpringBootApp.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
    public Category findByName(String categoryName);
}
