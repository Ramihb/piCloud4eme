package com.esprit.pi.entities;

import javax.persistence.*;


@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @Column(name = "bookId", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column(name = "bookName", length = 255)
    private String bookName;
    @Column(name = "bookDescription", length = 255)
    private String bookDescription;
    @Column(name = "bookPDF", length = 255)
    private String bookPDF;
    @Column(name = "rating", length = 255)
    private Float rating;
    @Column(name = "feedback", length = 255)
    private String feedback;
 @Column(name = "bookPIC", length = 255)
    private String bookPIC;

    public String getBookDescription() {
        return bookDescription;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookPIC(String bookPIC) {
        this.bookPIC = bookPIC;
    }

    public BookEntity(int bookId, String bookName, String bookDescription, String bookPDF, Float rating,
            String feedback, String bookPIC) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPDF = bookPDF;
        this.rating = rating;
        this.feedback = feedback;
        this.bookPIC = bookPIC;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookPDF() {
        return bookPDF;
    }

    public String getFeedback() {
        return feedback;
    }

    public Float getRating() {
        return rating;
    }

    public BookEntity() {
    }

    public BookEntity(int bookId, String bookName, String bookDescription, String bookPDF, Float rating,
            String feedback) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPDF = bookPDF;
        this.rating = rating;
        this.feedback = feedback;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPDF(String bookPDF) {
        this.bookPDF = bookPDF;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getBookPIC() {
        return bookPIC;
    }
}
