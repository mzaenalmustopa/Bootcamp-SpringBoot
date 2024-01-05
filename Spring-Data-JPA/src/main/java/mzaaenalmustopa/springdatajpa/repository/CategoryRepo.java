package mzaaenalmustopa.springdatajpa.repository;

import mzaaenalmustopa.springdatajpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    // where firstname = ?
    Optional<Category> findFirstByNameEquals(String name);

    // where name like ?
    List<Category> findAllByNameLike(String name);

}
