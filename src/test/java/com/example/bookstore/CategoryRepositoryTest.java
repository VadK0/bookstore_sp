package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
    private CategoryRepository repository;
	
	@Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Horror");
        
        assertThat(categories).hasSize(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category();
    	repository.save(category);
    	assertThat(category.getCatid()).isNotNull();
    }
}
