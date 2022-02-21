package cg.wbd.grandemonstration.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class FeedBack{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int star;
    private String author;
    private String feedback;
    private Date time;
    private int numberOfLike=0;

    public FeedBack() {
    }

    public FeedBack(int star, String author, String feedback) {

        this.star = star;
        this.author = author;
        this.feedback = feedback;
        this.time=new Date();
    }

    public Long getId() {
        return id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", star=" + star +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", time=" + time +
                ", numberOfLike=" + numberOfLike +
                '}';
    }
}
