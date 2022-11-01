package org.example.dao;

import org.example.config.Config;
import org.example.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private final SessionFactory sessionFactory = Config.getSessionFactory();
    @Override
    public void saveCourse(Course course) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(course);
            System.out.println("Course saved successfully");
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.getMessage();
        }
    }

    @Override
    public Course getCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.getTransaction().commit();
            session.close();
            return course;
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        } return null;
    }
    @Override
    public List<Course> getAllCourse() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c", Course.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return courses;

        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public Course updateCourse(Long id, String courseName, int duration, LocalDate createAt, String imageLink,
                               String description) {
        try {
            Session session = Config.getSessionFactory().openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            course.setId(id);
            course.setCourseName(courseName);
            course.setDuration(duration);
            course.setCreateAt(createAt);
            course.setImageLink(imageLink);
            course.setDescription(description);
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void deleteCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.remove(course);
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getCourseByName(String name) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course= (Course) session.createQuery("select c  from Course c where c.courseName =: name").setParameter("name",name).getSingleResult();
            System.out.println(course);
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
