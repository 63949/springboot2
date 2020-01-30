package com.example.demo.repository;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/***
 * https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
 */
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser(Optional<User> user);
}
