package org.example.dao;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);

    Instructor updateInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long instructorId, Long courseId);





}
