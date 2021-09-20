package com.api.realtime.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ageanalysis implements Serializable {
//    private Long id;
    private int ageId;
    private int newsId;
    private double tens;
    private double twenties;
    private double thirties;
    private double fourties;
    private double fifties;
    private double sixties;

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
    @Column(name = "age_id")
    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
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
    @Column(name = "tens")
    public double getTens() {
        return tens;
    }

    public void setTens(double tens) {
        this.tens = tens;
    }

    @Basic
    @Column(name = "twenties")
    public double getTwenties() {
        return twenties;
    }

    public void setTwenties(double twenties) {
        this.twenties = twenties;
    }

    @Basic
    @Column(name = "thirties")
    public double getThirties() {
        return thirties;
    }

    public void setThirties(double thirties) {
        this.thirties = thirties;
    }

    @Basic
    @Column(name = "fourties")
    public double getFourties() {
        return fourties;
    }

    public void setFourties(double fourties) {
        this.fourties = fourties;
    }

    @Basic
    @Column(name = "fifties")
    public double getFifties() {
        return fifties;
    }

    public void setFifties(double fifties) {
        this.fifties = fifties;
    }

    @Basic
    @Column(name = "sixties")
    public double getSixties() {
        return sixties;
    }

    public void setSixties(double sixties) {
        this.sixties = sixties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ageanalysis that = (ageanalysis) o;
        return ageId == that.ageId && newsId == that.newsId && Double.compare(that.tens, tens) == 0 && Double.compare(that.twenties, twenties) == 0 && Double.compare(that.thirties, thirties) == 0 && Double.compare(that.fourties, fourties) == 0 && Double.compare(that.fifties, fifties) == 0 && Double.compare(that.sixties, sixties) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageId, newsId, tens, twenties, thirties, fourties, fifties, sixties);
    }
}
