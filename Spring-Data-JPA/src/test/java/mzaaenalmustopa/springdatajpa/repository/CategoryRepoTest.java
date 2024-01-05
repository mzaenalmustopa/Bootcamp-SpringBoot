package mzaaenalmustopa.springdatajpa.repository;

import mzaaenalmustopa.springdatajpa.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo repository;

    @Test
    void insert() {
        Category category = new Category();
        category.setName("LAPTOP");

        repository.save(category);

        assertNotNull(category.getId());
    }

    @Test
    void update() {
        Category category = repository.findById(1L).orElse(null);
        assertNotNull(category);

        category.setName("GADGET MURAH");
        repository.save(category);

       // repository.delete(category);

        category = repository.findById(1L).orElse(null);
        assertNotNull(category);
        assertEquals("GADGET MURAH", category.getName());
    }

    @Test
    void queryMethod() {
        Category category = repository.findFirstByNameEquals("GADGET MURAH").orElse(null);
        assertNotNull(category);
        assertEquals("GADGET MURAH", category.getName());

        List<Category> categories = repository.findAllByNameLike("%GADGET%");
        assertEquals(1, categories.size());
        assertEquals("GADGET MURAH", categories.get(0).getName());
    }

    @Test
    void audit() {
        Category category = new Category();
        category.setName("Sample Audit");
        repository.save(category);

        assertNotNull(category.getId());
        assertNotNull(category.getCreatedDate());
        assertNotNull(category.getLastModifiedDate());
    }

    @Test
    void example1() {
        Category category = new Category();
        category.setName("GADGET MURAH");

        Example<Category> example = Example.of(category);

        List<Category> categories = repository.findAll(example);
        assertEquals(1, categories.size());
    }

    @Test
    void example2() {
        Category category = new Category();
        category.setName("GADGET MURAH");
        category.setId(1L);

        Example<Category> example = Example.of(category);

        List<Category> categories = repository.findAll(example);
        assertEquals(1, categories.size());
    }

    @Test
    void exampleMatcher() {
        Category category = new Category();
        category.setName("gadget MURAH");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withIgnoreCase();

        Example<Category> example = Example.of(category, matcher);

        List<Category> categories = repository.findAll(example);
        assertEquals(1, categories.size());
    }
}