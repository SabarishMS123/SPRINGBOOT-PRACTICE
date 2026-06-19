package com.restaurant.repository;

import com.restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByIsVegetarian(Boolean isVegetarian);
    void deleteByName(String name);
    
    // Update stock quantity
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stockQuantity = p.stockQuantity - :quantity WHERE p.id = :productId AND p.stockQuantity >= :quantity")
    int reduceStock(@Param("productId") Long productId, @Param("quantity") Integer quantity);
    
    // Find products with low stock
    List<Product> findByStockQuantityLessThan(Integer stock);
    
    // Find products out of stock
    List<Product> findByStockQuantity(Integer stock);
}