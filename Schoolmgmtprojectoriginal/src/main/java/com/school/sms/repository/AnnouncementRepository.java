package com.school.sms.repository;

import com.school.sms.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    
    // Get all announcements ordered by date (latest first)
    List<Announcement> findAllByOrderByPostedDateDesc();
    
    // For targeted announcements (optional filtering)
    @Query("SELECT a FROM Announcement a WHERE a.targetAudience = 'ALL' OR a.targetAudience IS NULL ORDER BY a.postedDate DESC")
    List<Announcement> findGeneralAnnouncements();
    
    List<Announcement> findByTargetAudienceContaining(String className);
}