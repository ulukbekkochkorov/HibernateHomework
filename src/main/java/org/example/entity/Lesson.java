package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "video_link")
    private String videoLink;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST})
    private Course course;

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, PERSIST, REMOVE}, fetch = FetchType.EAGER)
    private List<Task> task = new ArrayList<Task>();

    public Lesson(String name, String videoLink, Long courseId) {
        this.name = name;
        this.videoLink = videoLink;

    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}