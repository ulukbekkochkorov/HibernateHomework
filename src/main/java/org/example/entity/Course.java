package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    private int duration;

    private LocalDate createAt;

    private String imageLink;

    private String description;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = FetchType.EAGER, mappedBy = "course")
    private List<Instructor> instructors = new ArrayList<>();

    public void addInstructor(Instructor instructor){
        System.out.println(instructors.add(instructor));

    }

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, REMOVE,PERSIST}, mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<Lesson>();

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
