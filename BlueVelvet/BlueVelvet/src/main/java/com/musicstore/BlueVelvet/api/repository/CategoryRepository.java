package com.musicstore.BlueVelvet.api.repository;

import com.musicstore.BlueVelvet.api.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> findAllByParentIsNull(Pageable pageable);


    boolean existsByName(String name);
}