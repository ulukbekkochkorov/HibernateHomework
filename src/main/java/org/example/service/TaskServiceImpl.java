package org.example.service;

import org.example.dao.TaskDao;
import org.example.dao.TaskDaoImpl;
import org.example.entity.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao = new TaskDaoImpl();

    @Override
    public void saveTask(Task task) {
        taskDao.saveTask(task);

    }

    @Override
    public Task updateTask(Long id, Task task) {
        taskDao.updateTask(id, task);
        return null;
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {

        taskDao.getAllTaskByLessonId(id);
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        taskDao.deleteTaskById(id);
    }
}
