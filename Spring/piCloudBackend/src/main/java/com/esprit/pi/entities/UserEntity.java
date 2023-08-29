package com.esprit.pi.entities;
import javax.persistence.*;
@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @Column(name="userId", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name="firstName", length = 255)
    private String firstName;
    @Column(name="lastName", length = 255)
    private String lastName;
    @Column(name="phoneNumber")
    private int phoneNumber;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;
    public UserEntity() {
    }
    public UserEntity(int userId, String firstName,String lastName, int phoneNumber, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
