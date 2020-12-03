package com.nativeboyz.vmall.repositories.products;

import com.nativeboyz.vmall.models.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductEntity, UUID> {

    @Query(value = "SELECT p FROM ProductEntity AS p WHERE p.customerEntity.id = :id",
            countQuery = "SELECT COUNT(p) FROM ProductEntity AS p WHERE p.customerEntity.id = :id")
    Page<ProductEntity> findCustomerProducts(@Param("id") UUID id, Pageable pageable);

}
