package com.school.sms.controller;

import com.school.sms.entity.*;
import com.school.sms.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
@PreAuthorize("hasRole('PARENT')")
@CrossOrigin(origins = "*")
public class ParentController {

    private final StudentService studentService;
    private final AttendanceService attendanceService;
    private final ExamService examService;
    private final AnnouncementService announcementService;

    public ParentController(StudentService studentService, AttendanceService attendanceService,
                            ExamService examService, AnnouncementService announcementService) {
        this.studentService = studentService;
        this.attendanceService = attendanceService;
        this.examService = examService;
        this.announcementService = announcementService;
    }

    @GetMapping("/child")
    public Student getMyChild(Authentication auth) {
        return studentService.getChildByParent(auth.getName());
    }

    @GetMapping("/child/attendance")
    public List<Attendance> getChildAttendance(Authentication auth) {
        Student child = studentService.getChildByParent(auth.getName());
        return attendanceService.getAttendanceByStudent(child.getId());
    }

    @GetMapping("/child/results")
    public List<Result> getChildResults(Authentication auth) {
        Student child = studentService.getChildByParent(auth.getName());
        return examService.getResultsByStudent(child.getId());
    }

    @GetMapping("/announcements")
    public List<AnnouncementDto> getAnnouncements() {
        return announcementService.getAllAnnouncements();
    }
}