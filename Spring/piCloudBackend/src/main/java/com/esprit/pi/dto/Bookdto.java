package com.esprit.pi.dto;


public class Bookdto {

    private int bookId;
    private String bookName;
    private String bookDescription;
    private String bookPDF;
    private Float rating;
    private String feedback;
  

    public String getBookDescription() {
        return bookDescription;
    }

    public int getBookId() {
        return bookId;
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

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Bookdto() {
    }

    public Bookdto(int bookId, String bookName, String bookDescription, String bookPDF, Float rating, String feedback) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPDF = bookPDF;
        this.rating = rating;
       
        this.feedback = feedback;
        
    }

   

}
