package ru.kpfu.itis.teachersrating.model;

import javax.persistence.*;

@Entity
@Table(name = "TeacherRatings")
public class TeacherRating {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne
    private User teacher;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "voteAmount")
    private int voteAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getVoteAmount() {
        return voteAmount;
    }

    public void setVoteAmount(int voteAmount) {
        this.voteAmount = voteAmount;
    }
}
