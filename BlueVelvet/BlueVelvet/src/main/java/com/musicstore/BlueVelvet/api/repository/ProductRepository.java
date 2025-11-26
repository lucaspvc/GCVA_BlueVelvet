package com.musicstore.BlueVelvet.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.musicstore.BlueVelvet.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
