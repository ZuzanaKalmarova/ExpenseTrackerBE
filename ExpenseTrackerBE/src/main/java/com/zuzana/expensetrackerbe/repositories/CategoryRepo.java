package com.zuzana.expensetrackerbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zuzana.expensetrackerbe.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
