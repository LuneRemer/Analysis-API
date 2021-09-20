package com.api.realtime.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class genderanalysis implements Serializable {
//    private Long id;
    private int genderId;
    private int newsId;
    private double male;
    private double female;

//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @Id
    @Column(name = "gender_id")
    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Basic
    @Column(name = "news_id")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "male")
    public double getMale() {
        return male;
    }

    public void setMale(double male) {
        this.male = male;
    }

    @Basic
    @Column(name = "female")
    public double getFemale() {
        return female;
    }

    public void setFemale(double female) {
        this.female = female;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        genderanalysis that = (genderanalysis) o;
        return genderId == that.genderId && newsId == that.newsId && Double.compare(that.male, male) == 0 && Double.compare(that.female, female) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId, newsId, male, female);
    }
}
