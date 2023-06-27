package com.example.Phase3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends CrudRepository<Users, Long>{
	@Query("SELECT * FROM users WHERE username LIKE %:keyword%")
    Iterable<Users> searchByUsername(@Param("keyword") String keyword);
}
