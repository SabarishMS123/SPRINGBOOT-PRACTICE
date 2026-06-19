// com.school.sms.entity.Assignment.java
package com.school.sms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

    // getters and setters
}