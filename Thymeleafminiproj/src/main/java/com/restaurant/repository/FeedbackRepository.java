package com.restaurant.repository;

import com.restaurant.entity.Feedback;
import com.restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByProductOrderByCreatedAtDesc(Product product);
    
    @Query("SELECT AVG(f.rating) FROM Feedback f WHERE f.product = :product")
    Double getAverageRatingForProduct(@Param("product") Product product);
    
    @Query("SELECT COUNT(f) FROM Feedback f WHERE f.product = :product")
    Long getFeedbackCountForProduct(@Param("product") Product product);
}