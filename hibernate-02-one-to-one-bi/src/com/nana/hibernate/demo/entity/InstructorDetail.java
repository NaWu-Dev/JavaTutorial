package com.nana.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    // Steps:
    // annotate the class as entity and map to db table
    // define the fields
    // annotate the fields with db column name
    // create constructors
    // generate getter / setter methods
    // generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannle;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannle, String hobby) {
        this.youtubeChannle = youtubeChannle;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannle() {
        return youtubeChannle;
    }

    public void setYoutubeChannle(String youtubeChannle) {
        this.youtubeChannle = youtubeChannle;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannle='" + youtubeChannle + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
