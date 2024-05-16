package org.example.smartdeltasystems.service;

import org.example.smartdeltasystems.dto.StudentDto;
import org.example.smartdeltasystems.entity.Student;
import org.example.smartdeltasystems.mapper.StudentMapper;
import org.example.smartdeltasystems.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::toDto)
                .orElse(null);
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.toEntity(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toDto(savedStudent);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElse(null);

        if (existingStudent != null) {
            existingStudent.setLastName(studentDto.getLastName());
            existingStudent.setFirstName(studentDto.getFirstName());
            existingStudent.setMiddleName(studentDto.getMiddleName());
            existingStudent.setStudentGroup(studentDto.getStudentGroup());
            existingStudent.setAverageGrade(studentDto.getAverageGrade());

            return StudentMapper.toDto(studentRepository.save(existingStudent));
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
