package org.example.dao;

import org.example.entity.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao {

    void saveCourse(Course course);

     Course getCourseById(Long id);

    ;

    List<Course> getAllCourse();


    Course updateCourse(Long id, String courseName, int duration, LocalDate createAt, String imageLink,
                        String description);

    void deleteCourseById(Long id);

    void getCourseByName(String name);


}

