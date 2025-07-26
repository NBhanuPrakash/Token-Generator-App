package com.NNTeachie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer sequenceId;

    private String userName;

    private String fullName;

    private String designation;

    private Long articles;

    private Long followers;

    private Double rating;

    public UserDetails() {
    }

    public UserDetails(String userName, String fullName, String designation, Long userNumber, Long followers, Double rating) {
        this.userName = userName;
        this.fullName = fullName;
        this.designation = designation;
        this.articles = userNumber;
        this.followers = followers;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getArticles() {
        return articles;
    }

    public void setArticles(Long articles) {
        this.articles = articles;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
