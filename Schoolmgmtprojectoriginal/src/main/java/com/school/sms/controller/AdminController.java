package com.school.sms.controller;

import com.school.sms.dto.entity.*;
import com.school.sms.entity.*;
import com.school.sms.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin(origins = "*")
public class AdminController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ClassRoomService classRoomService;
    private final SubjectService subjectService;
    private final AnnouncementService announcementService;
    private final TimetableService timetableService;

    public AdminController(TeacherService teacherService, StudentService studentService,
                           ClassRoomService classRoomService, SubjectService subjectService,
                           AnnouncementService announcementService, TimetableService timetableService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.classRoomService = classRoomService;
        this.subjectService = subjectService;
        this.announcementService = announcementService;
        this.timetableService = timetableService;
    }

    // Teachers
    @GetMapping("/teachers")
    public List<TeacherDto> getAllTeachers() { return teacherService.getAllTeachers(); }

    @PostMapping("/teachers")
    public TeacherDto createTeacher(@RequestBody TeacherDto dto) { return teacherService.createTeacher(dto); }

    @PutMapping("/teachers/{id}")
    public TeacherDto updateTeacher(@PathVariable Long id, @RequestBody TeacherDto dto) { return teacherService.updateTeacher(id, dto); }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) { teacherService.deleteTeacher(id); return ResponseEntity.ok("Deleted"); }

    // Students
    @GetMapping("/students")
    public List<StudentDto> getAllStudents() { return studentService.getAllStudents(); }

    @PostMapping("/students")
    public StudentDto createStudent(@RequestBody StudentDto dto) { return studentService.createStudent(dto); }

    // Classes
    @GetMapping("/classes")
    public List<ClassRoom> getAllClasses() { return classRoomService.getAllClasses(); }

    @PostMapping("/classes")
    public ClassRoom createClass(@RequestBody ClassRoom classRoom) { return classRoomService.createClass(classRoom); }

    // Subjects
    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() { return subjectService.getAllSubjects(); }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject) { return subjectService.createSubject(subject); }

    // Assign Teacher to Class & Subject
    @PostMapping("/assign-teacher")
    public ResponseEntity<?> assignTeacher(@RequestBody TeacherAssignmentDto dto) {
        timetableService.assignTeacher(dto.getTeacherId(), dto.getClassId(), dto.getSubjectId());
        return ResponseEntity.ok("Teacher assigned");
    }

    // Announcements
    @PostMapping("/announcements")
    public AnnouncementDto createAnnouncement(@RequestBody AnnouncementDto dto) { return announcementService.createAnnouncement(dto); }

    @GetMapping("/announcements")
    public List<AnnouncementDto> getAllAnnouncements() { return announcementService.getAllAnnouncements(); }
}