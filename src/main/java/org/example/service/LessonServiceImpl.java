package org.example.service;

import org.example.dao.LessonDao;
import org.example.dao.LessonDaoImpl;
import org.example.entity.Lesson;

import java.util.List;

public class LessonServiceImpl implements LessonService{

    LessonDao lessonDao = new LessonDaoImpl();
    @Override
    public void saveLesson(Lesson lesson) {
        lessonDao.saveLesson(lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        lessonDao.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        lessonDao.getLessonById(id);
        return null;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        lessonDao.getLessonByCourseId(id);
        return null;
    }
}
