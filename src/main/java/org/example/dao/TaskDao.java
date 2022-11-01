package org.example.dao;

import org.example.entity.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Task task);

    Task updateTask(Long id, Task task);

    List<Task> getAllTaskByLessonId(Long id);

    void deleteTaskById(Long id);

}
