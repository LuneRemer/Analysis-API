package com.api.realtime.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class comments implements Serializable {
//    private Long id;
    private int commentsId;
    private int newsId;
    private String contents;
    private String writer;
    private int recommended;
    private int unrecommended;
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
    @Column(name = "comments_id")
    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
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
    @Column(name = "contents")
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Basic
    @Column(name = "writer")
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Basic
    @Column(name = "recommended")
    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    @Basic
    @Column(name = "unrecommended")
    public int getUnrecommended() {
        return unrecommended;
    }

    public void setUnrecommended(int unrecommended) {
        this.unrecommended = unrecommended;
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
        comments comments = (com.api.realtime.demo.entity.comments) o;
        return commentsId == comments.commentsId && newsId == comments.newsId && recommended == comments.recommended && unrecommended == comments.unrecommended && Objects.equals(contents, comments.contents) && Objects.equals(writer, comments.writer) && Objects.equals(date, comments.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentsId, newsId, contents, writer, recommended, unrecommended, date);
    }
}
