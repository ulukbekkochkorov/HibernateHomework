package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao{
    private final SessionFactory sessionFactory = Config.getSessionFactory();
    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(instructor);
            System.out.println("Instructor saved successfully");
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.getMessage();
        }
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor1 = session.get(Instructor.class, id);
            instructor1.setId(id);
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());
            session.getTransaction().commit();
            session.close();
            return instructor1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(instructor);
            session.getTransaction().commit();
            session.close();
            return instructor;
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        } return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        List<Instructor> instructors = null;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class, id);
           instructors= course.getInstructors();
           session.getTransaction().commit();
           session.close();
        } catch (HibernateException e) {
            e.getMessage();
        } return instructors;
    }
    @Override
    public void deleteInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            session.remove(instructor);
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course course = session.find(Course.class, courseId);
        Instructor instructor = session.find(Instructor.class, instructorId);

        List<Course> courses = new ArrayList<>();
        courses.add(course);

        instructor.setCourse(courses);
        course.addInstructor(instructor);
        session.persist(instructor);

        session.getTransaction().commit();
        session.close();


    }


}
