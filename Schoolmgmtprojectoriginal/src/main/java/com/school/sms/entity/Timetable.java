// com.school.sms.entity.Timetable.java
package com.school.sms.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "timetables")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ClassRoom classRoom;

    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

    // getters and setters
}