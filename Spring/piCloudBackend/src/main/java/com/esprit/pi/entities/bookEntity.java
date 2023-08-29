package com.esprit.pi.entities;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="book")
public class bookEntity {
    @Id
    @Column(name="bookId", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column(name="bookName", length = 255)
    private String bookName;
    @Column(name="bookDescription", length = 255)
    private String bookDescription;
    @Column(name="bookPDF", length = 255)
    private String bookPDF;
    @Column(name="rating", length = 255)
    private Float rating;
    @Column(name="feedback", length = 255)
    private Optional<String> feedback;
}
