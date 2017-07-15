package ru.kpfu.itis.teachersrating.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "StudentGroups")
public class StudentGroup {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "groupNumber", nullable = false)
    private String groupNumber;

    @Column(name = "grade")
    private Integer grade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "instituteId")
    private Institute institute;

    @OneToMany
    private Set<User> students;

    @ManyToMany
    private Set<User> teachers;

    public StudentGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    public Set<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<User> teachers) {
        this.teachers = teachers;
    }
}
