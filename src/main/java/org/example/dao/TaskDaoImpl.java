package org.example.dao;

import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TaskDaoImpl implements TaskDao {

    private final SessionFactory sessionFactory = Config.getSessionFactory();

    @Override
    public void saveTask(Task task) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Task task1 = session.get(Task.class, id);
            task1.setId(id);
            task1.setName(task.getName());
            task1.setDeadLine(task.getDeadLine());
            task1.setTask(task.getTask());
            session.getTransaction().commit();
            session.close();
            return task1;
        } catch (HibernateException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
            try {
                List<Task> tasks = null;
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Lesson lesson = session.get(Lesson.class, id);
                tasks = lesson.getTask();
                session.getTransaction().commit();
                session.close();
                return tasks;
            } catch (HibernateException e) {
                e.getMessage();
            }return null;
        }

    @Override
    public void deleteTaskById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task = session.get(Task.class, id);
            session.remove(task);
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e){
            e.getMessage();
        }
    }
}
