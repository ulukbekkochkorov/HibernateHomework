package org.example.service;

import org.example.dao.CourseDao;
import org.example.dao.CourseDaoImpl;
import org.example.entity.Course;
import org.hibernate.HibernateException;

import java.time.LocalDate;
import java.util.List;

public class CourseServiceImpl implements CourseService{
    private CourseDao courseDao = new CourseDaoImpl();


    @Override
    public void saveCourse(Course course) {
        try {
            courseDao.saveCourse(course);

        } catch (HibernateException e) {
            e.getMessage();
        }
    }

    @Override
    public void getCourseById(Long id) {
        courseDao.getCourseById(id);
        }

    @Override
    public List<Course> getAllCourse() {
        courseDao.getAllCourse();
        return null;
    }

    @Override
    public void updateCourse(Long id, String courseName, int duration, LocalDate createAt, String imageLink,
                             String description) {
        courseDao.updateCourse(id, courseName, duration,createAt, imageLink,description);

    }

    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);

    }

    @Override
    public void getCourseByName(String name) {
        courseDao.getCourseByName(name);

    }
}
