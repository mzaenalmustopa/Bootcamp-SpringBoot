package mzaaenalmustopa.springdatajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import mzaaenalmustopa.springdatajpa.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void testEntityManagerFactory() {
        Assertions.assertNotNull(entityManagerFactory);

        EntityManager entityManagerFactory1 = entityManagerFactory.createEntityManager();
        Assertions.assertNotNull(entityManagerFactory1);

        entityManagerFactory1.close();
    }
}
