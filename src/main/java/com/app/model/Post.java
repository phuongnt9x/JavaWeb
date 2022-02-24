package com.app.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@ToString(exclude = "category")
@EqualsAndHashCode(exclude = "category")
@Entity
@Table()
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    private String content;
    private Date date;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public Post() {}

    public Long getId() {
        return id;
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
