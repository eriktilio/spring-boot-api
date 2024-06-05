package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.models.User;

@Repository
public interface Database extends CrudRepository<User, Integer> {
    @SuppressWarnings("null")
    List<User> findAll();

    @Query(value = "SELECT * FROM users WHERE name LIKE %:name%", nativeQuery = true)
    List<User> findByName(String name);
}
