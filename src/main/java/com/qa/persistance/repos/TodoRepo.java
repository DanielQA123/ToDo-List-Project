package com.qa.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.persistance.domain.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
