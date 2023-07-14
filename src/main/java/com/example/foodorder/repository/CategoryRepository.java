package com.example.foodorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.foodorder.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query(value = "select c from Category c")
	List<Category> findCategory();

}
