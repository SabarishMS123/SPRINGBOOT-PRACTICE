package com.school.sms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "attendance",
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "date"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean present = true;

    private String remarks;

	public void setStudent(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setDate(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setPresent(Object present2) {
		// TODO Auto-generated method stub
		
	}

	public void setRemarks(Object remarks2) {
		// TODO Auto-generated method stub
		
	}

	public Object getStudent() {
		// TODO Auto-generated method stub
		return null;
	}
}