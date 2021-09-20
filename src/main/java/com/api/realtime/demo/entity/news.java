package com.api.realtime.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@NamedQuery(name = "News.byNewsId", query = "select e from news e where e.newsId > ?1")
@NamedQuery(name = "findAllNews", query = "select e from news e where e.newsId >= 0")
public class news implements Serializable {
//    private Long id;
    private int newsId;
    private String title;
    private String url;
    private Timestamp date;

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
    @GeneratedValue
    @Column(name = "news_id")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        news news = (com.api.realtime.demo.entity.news) o;
        return newsId == news.newsId && Objects.equals(title, news.title) && Objects.equals(url, news.url) && Objects.equals(date, news.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, title, url, date);
    }
}
