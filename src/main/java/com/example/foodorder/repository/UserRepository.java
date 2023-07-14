package com.example.foodorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.foodorder.model.Category;
import com.example.foodorder.model.FoodAppUser;

@Repository
public interface UserRepository extends JpaRepository<FoodAppUser, Integer> {


}
