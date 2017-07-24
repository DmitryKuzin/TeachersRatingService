package ru.kpfu.itis.teachersrating.model;

import org.springframework.stereotype.Component;

@Component
public class TeacherRating {
    private Long teacherId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String imagePath;
    private String description;
    private Double rating;
    private Long voteAmount;

    public TeacherRating(Long teacherId, String firstName, String lastName, String patronymic, String imagePath, String description, Double rating, Long voteAmount) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.imagePath = imagePath;
        this.description = description;
        this.rating = rating;
        this.voteAmount = voteAmount;
    }

    public TeacherRating(Long teacherId, String firstName, String lastName, String patronymic, String imagePath, String description) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.imagePath = imagePath;
        this.description = description;
    }

    public TeacherRating() {
    }

    public Long getId() {
        return teacherId;
    }

    public void setId(Long id) {
        this.teacherId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getVoteAmount() {
        return voteAmount;
    }

    public void setVoteAmount(Long voteAmount) {
        this.voteAmount = voteAmount;
    }

    @Override
    public String toString() {
        return "TeacherRate{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", voteAmount=" + voteAmount +
                '}';
    }
}
