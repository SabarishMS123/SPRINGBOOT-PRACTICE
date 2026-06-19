package com.school.sms.controller;

import com.school.sms.dto.entity.*;
import com.school.sms.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@PreAuthorize("hasRole('STUDENT')")
@CrossOrigin(origins = "*")
public class StudentController {

    private final AttendanceService attendanceService;
    private final ExamService examService;
    private final TimetableService timetableService;
    private final AnnouncementService announcementService;

    public StudentController(AttendanceService attendanceService, ExamService examService,
                              TimetableService timetableService, AnnouncementService announcementService) {
        this.attendanceService = attendanceService;
        this.examService = examService;
        this.timetableService = timetableService;
        this.announcementService = announcementService;
    }

    @GetMapping("/timetable")
    public List<TimetableDto> getTimetable(@RequestParam Long classId) {
        return timetableService.getTimetableByClass(classId);
    }

    @GetMapping("/attendance")
    public List<Attendance> getMyAttendance(Authentication auth) {
        return attendanceService.getAttendanceByStudent(auth.getName());
    }

    @GetMapping("/results")
    public List<Result> getMyResults(Authentication auth) {
        return examService.getResultsByStudent(auth.getName());
    }

    @GetMapping("/announcements")
    public List<AnnouncementDto> getAnnouncements() {
        return announcementService.getAllAnnouncements();
    }
}