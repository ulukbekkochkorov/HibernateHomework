package org.example.service;
import org.example.entity.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {

        void saveCourse(Course course);

        void getCourseById(Long id);

//        List<Course> getAllCourse();

    List<Course> getAllCourse();

    void updateCourse(Long id, String courseName, int duration, LocalDate createAt, String imageLink,
                      String description);

        void deleteCourseById(Long id);

        void getCourseByName(String name);
    }

