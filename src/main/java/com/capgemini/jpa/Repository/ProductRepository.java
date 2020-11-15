package com.capgemini.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.jpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
