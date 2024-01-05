package mzaaenalmustopa.springdatajpa.repository;

import mzaaenalmustopa.springdatajpa.entity.Category;
import mzaaenalmustopa.springdatajpa.entity.Product;
import mzaaenalmustopa.springdatajpa.model.SimpleProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.support.TransactionOperations;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void createProducts() {
        Category category = categoryRepo.findById(1L).orElse(null);
        assertNotNull(category);

        {
            Product product = new Product();
            product.setName("Apple iPhone 14 Pro Max");
            product.setPrice(25_000_000L);
            product.setCategory(category);
            productRepo.save(product);
        }

        {
            Product product = new Product();
            product.setName("Apple iPhone 13 Pro Max");
            product.setPrice(18_000_000L);
            product.setCategory(category);
            productRepo.save(product);
        }
    }

    @Test
    void findByCategoryName() {
        List<Product> products = productRepo.findAllByCategory_Name("GADGET MURAH");
         assertEquals(2, products.size());
        assertEquals("Apple iPhone 14 Pro Max", products.get(0).getName());
        assertEquals("Apple iPhone 13 Pro Max", products.get(1).getName());
    }

    @Test
    void sort() {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<Product> products = productRepo.findAllByCategory_Name("GADGET MURAH", sort);
        assertEquals(2, products.size());
        assertEquals("Apple iPhone 13 Pro Max", products.get(0).getName());
        assertEquals("Apple iPhone 14 Pro Max", products.get(1).getName());
    }

    @Test
    void pageable() {
        // page 0
        Pageable pageable = PageRequest.of(0,1, Sort.by(Sort.Order.desc("id")));
        Page<Product> products = productRepo.findAllByCategory_Name("GADEGET MURAH", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(0,products.getNumber());
        assertEquals(2,products.getTotalElements());
        assertEquals(2,products.getTotalPages());
        assertEquals("Apple iPhone 13 Pro Max", products.getContent().get(0).getName());

        // page 1
        pageable  = PageRequest.of(1,1, Sort.by(Sort.Order.desc("id")));
        products = productRepo.findAllByCategory_Name("GADEGET MURAH", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(1,products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
        assertEquals("Apple iPhone 14 Pro Max", products.getContent().get(0).getName());
    }

    @Test
    void count() {
        Long count = productRepo.count();
        assertEquals(2L, count);

        count = productRepo.countByCategory_Name("GADGET MURAH");
        assertEquals(2L, count);

        count = productRepo.countByCategory_Name("GAK ADA");
        assertEquals(0L, count);
    }

    @Test
    void exists() {
        boolean exists = productRepo.existsByName("Apple iPhone 14 Pro Max");
        assertTrue(exists);

        exists = productRepo.existsByName("Apple iPhone 14 Pro Max SALAH");
        assertFalse(exists);
    }

    @Test
    void testDelete() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            Category category = categoryRepo.findById(1L).orElse(null);
            assertNotNull(category);

            Product product = new Product();
            product.setName("Samsung Galaxy S9");
            product.setPrice(10_000_000L);
            product.setCategory(category);
            productRepo.save(product);

            int delete = productRepo.deleteByName("Samsung Galaxy S9");
            assertEquals(1, delete);

            delete = productRepo.deleteByName("Samsung Galaxy S9");
            assertEquals(0, delete);
        });
    }

    @Test
    void deleteNew() {
        Category category = categoryRepo.findById(1L).orElse(null);
        assertNotNull(category);

        Product product = new Product();
        product.setName("Samsung Galaxy S9");
        product.setPrice(10_000_000L);
        product.setCategory(category);
        productRepo.save(product);

        int delete = productRepo.deleteByName("Samsung Galaxy S9");
        assertEquals(1, delete);

        delete = productRepo.deleteByName("Samsung Galaxy S9");
        assertEquals(0, delete);
    }

    @Test
    void namedQuery() {
        Pageable pageable = PageRequest.of(0,1);
        List<Product> products = productRepo.searchProductUsingName("Apple iPhone 14 Pro Max", pageable);
        assertEquals(1, products.size());
        assertEquals("Apple iPhone 14 Pro Max", products.get(0).getName());
    }

    @Test
    void searchProducts() {
        Pageable pageable = PageRequest.of(0,1,Sort.by(Sort.Order.desc("id")));
        Page<Product> products = productRepo.searchProduct("%iPhone%", pageable);
        assertEquals(1, products.getContent().size());

        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalPages());
        assertEquals(2,products.getTotalElements());

        products = productRepo.searchProduct("%GADGET%", pageable);
        assertEquals(1,products.getContent().size());

        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalPages());
        assertEquals(2,products.getTotalElements());
    }

    @Test
    void modifying() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            int total = productRepo.deleteProductUsingName("Wrong");
            assertEquals(0, total);

            total = productRepo.updateProductPriceToZero(1L);
            assertEquals(1, total);

            Product product = productRepo.findById(1L).orElse(null);
            assertNotNull(product);
            assertEquals(0L, product.getPrice());
        });
    }

    @Test
    void stream() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            Category category = categoryRepo.findById(1L).orElse(null);
            assertNotNull(category);

            Stream<Product> stream = productRepo.streamAllByCategory(category);
            stream.forEach(product -> System.out.println(product.getId() + " : " + product.getName()));
        });
    }

    @Test
    void slice() {
        Pageable pageable = PageRequest.of(0,1);

        Category category = categoryRepo.findById(1L).orElse(null);
        assertNotNull(category);

        Slice<Product> slice = productRepo.findAllByCategory(category, pageable);
        // tampilkan konten product
        while (slice.hasNext()){
            slice = productRepo.findAllByCategory(category, slice.getPageable());
        }
    }

    @Test
    void lock1() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            try {
                Product product = productRepo.findFirstByIdEquals(1L).orElse(null);
                assertNotNull(product);
                product.setPrice(30_000_000L);

                Thread.sleep(20_000L);
                productRepo.save(product);
            } catch (InterruptedException exception){
                throw new RuntimeException(exception);
            }
        });
    }

    @Test
    void lock2() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            Product product = productRepo.findFirstByIdEquals(1L).orElse(null);
            assertNotNull(product);
            product.setPrice(30_000_000L);
            productRepo.save(product);
        });
    }

    @Test
    void specification() {
        Specification<Product> specification = ((root, query, criteriaBuilder) -> {
            return query.where(
                    criteriaBuilder.or(
                            criteriaBuilder.equal(root.get("name"), "Apple iPhone 14 Pro Max"),
                            criteriaBuilder.equal(root.get("name"), "Apple iPhone 13 Pro Max")
                    )
            ).getRestriction();
        });

        List<Product> products = productRepo.findAll(specification);
        assertEquals(2, products.size());
    }

    @Test
    void projection() {
        List<SimpleProduct> simpleProducts = productRepo.findAllByNameLike("%Apple%");
        assertEquals(2, simpleProducts.size());
    }
}