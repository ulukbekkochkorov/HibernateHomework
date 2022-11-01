package org.example;

import org.example.config.Config;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.service.*;

import java.time.LocalDate;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Config.getSessionFactory();
        CourseServiceImpl courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();
//        courseService.saveCourse(new Course("java",9,LocalDate.now(),"image","web dev"));
//        courseService.saveCourse(new Course("JS", 9, LocalDate.now(),"image","web dev"));
//        courseService.getCourseById(2l);
//        courseService.getAllCourse();
//        courseService.updateCourse(1l, "Java8", 9,
//                LocalDate.of(2022, 11, 12), "image", "tyt");
//        courseService.deleteCourseById(1l);
//        courseService.getCourseByName("Java");
//instructorService.saveInstructor(new Instructor("Muhammad", "Alanov",
//        "alanov@gmail.com", "0555557755"));
//instructorService.updateInstructor(1l,new Instructor ("Janarbek", "Abdrasulov",
//        "j@gmail.com", "0555776655"));
//        instructorService.getInstructorById(1l);
//        instructorService.assignInstructorToCourse(1l, 2l);
//        System.out.println(instructorService.getInstructorByCourseId(3l));
//        instructorService.deleteInstructorById(1l);
//        lessonService.saveLesson(new Lesson("TehnicalEnglish","image",2l));
//        lessonService.updateLesson(2l, "Tehnical Engliosh", "video");
//        lessonService.getLessonById(1l);
//        lessonService.getLessonByCourseId(1l);
//        taskService.saveTask(new Task("Hibernate", LocalDate.of(22,10,01),  "task"));
//        taskService.updateTask(1l, new Task("Maven", LocalDate.of(22,10, 28), "coding"));
//        taskService.getAllTaskByLessonId(1l);
        taskService.deleteTaskById(1l);
    }
}
