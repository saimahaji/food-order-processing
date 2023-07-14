package com.example.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodorder.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
