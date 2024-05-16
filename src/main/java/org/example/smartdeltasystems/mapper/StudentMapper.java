package org.example.smartdeltasystems.mapper;

import org.example.smartdeltasystems.dto.StudentDto;
import org.example.smartdeltasystems.entity.Student;

public class StudentMapper {

    private StudentMapper() {
    }

    public static StudentDto toDto(Student student) {
        if (student == null) {
            return null;
        }
        StudentDto dto = new StudentDto();
        dtoToStudent(student, dto);
        return dto;
    }

    public static Student toEntity(StudentDto dto) {
        if (dto == null) {
            return null;
        }
        Student student = new Student();
        studentToDto(dto, student);
        return student;
    }

    private static void dtoToStudent(Student student, StudentDto dto) {
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setMiddleName(student.getMiddleName());
        dto.setStudentGroup(student.getStudentGroup());
        dto.setAverageGrade(student.getAverageGrade());
    }

    private static void studentToDto(StudentDto dto, Student student) {
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setMiddleName(dto.getMiddleName());
        student.setStudentGroup(dto.getStudentGroup());
        student.setAverageGrade(dto.getAverageGrade());
    }
}
