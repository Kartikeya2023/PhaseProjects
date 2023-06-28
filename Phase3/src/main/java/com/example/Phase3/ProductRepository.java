package com.example.Phase3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Products, Long> {
//	@Query("SELECT * FROM products WHERE category = :category")
//	Iterable<Products> findByCategory(@Param("category") String category);
}
