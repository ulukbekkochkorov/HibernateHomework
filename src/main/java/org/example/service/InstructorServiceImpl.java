package org.example.service;

import org.example.dao.InstructorDao;
import org.example.dao.InstructorDaoImpl;
import org.example.entity.Instructor;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private InstructorDao instructorDao = new InstructorDaoImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id, instructor);
    }

    @Override
    public void getInstructorById(Long id) {
         instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {

    }
}
