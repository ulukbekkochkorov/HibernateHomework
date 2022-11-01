package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import java.util.List;

public class LessonDaoImpl implements LessonDao {

    private final SessionFactory sessionFactory = Config.getSessionFactory();

    @Override
    public void saveLesson(Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(lesson);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.getMessage();
        }
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson1 = session.get(Lesson.class, id);
            lesson1.setId(id);
            lesson1.setName(lesson.getName());
            lesson1.setVideoLink(lesson.getVideoLink());
            lesson1.setCourse(lesson.getCourse());
            session.getTransaction().commit();
            session.close();
            return lesson1;
        } catch (HibernateException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, id);
            System.out.println(lesson);
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        try {
            List<Lesson> lessons = null;
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return lessons;
        } catch (HibernateException e) {
            e.getMessage();
        }return null;
    }
}