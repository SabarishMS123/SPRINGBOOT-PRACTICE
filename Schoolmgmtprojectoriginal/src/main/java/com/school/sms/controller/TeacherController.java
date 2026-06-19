package com.school.sms.controller;

import com.school.sms.dto.entity.*;
import com.school.sms.entity.Attendance;
import com.school.sms.entity.Result;
import com.school.sms.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@PreAuthorize("hasRole('TEACHER')")
@CrossOrigin(origins = "*")
public class TeacherController {

    private final AttendanceService attendanceService;
    private final ExamService examService;
    private final AssignmentService assignmentService;
    private final TimetableService timetableService;

    public TeacherController(AttendanceService attendanceService, ExamService examService,
                             AssignmentService assignmentService, TimetableService timetableService) {
        this.attendanceService = attendanceService;
        this.examService = examService;
        this.assignmentService = assignmentService;
        this.timetableService = timetableService;
    }

    @PostMapping("/attendance")
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceService.markAttendance(attendance);
    }

    @PostMapping("/exams")
    public ExamDto createExam(@RequestBody ExamDto examDto) { return examService.createExam(examDto); }

    @PostMapping("/results")
    public Result enterMarks(@RequestBody Result result) { return examService.enterMarks(result); }

    @GetMapping("/timetable")
    public List<TimetableDto> getMyTimetable(@RequestParam Long teacherId) {
        return timetableService.getTimetableByTeacher(teacherId);
    }

    @PostMapping("/assignments")
    public AssignmentDto createAssignment(@RequestBody AssignmentDto dto) {
        return assignmentService.createAssignment(dto);
    }
}