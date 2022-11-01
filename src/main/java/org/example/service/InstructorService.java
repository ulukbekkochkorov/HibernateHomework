package org.example.service;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorService {
    void saveInstructor(Instructor instructor);

    void updateInstructor(Long id, Instructor instructor);

    void getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long instructorId, Long courseId);
}
