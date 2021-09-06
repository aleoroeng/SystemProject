package com.systemproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Comparable<User>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private long contactNumber;
    private String emailId;
    private String address;
    private String businessJustification;
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dates")
    private Date date;
    //Constructors
    public User(){}

    public User(long id, String status){
        this.id = id;
        this.status = status;
    }
    public User(String firstName, String lastName, long contactNumber, String emailId, String address, String businessJustification, String status,Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.address = address;
        this.businessJustification = businessJustification;
        this.status = status;
        this.date = date;
    }

    //Getters and setters
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

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessJustification() {
        return businessJustification;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBusinessJustification(String businessJustification) {
        this.businessJustification = businessJustification;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber=" + contactNumber +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", businessJustification='" + businessJustification + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

    // Sort User objects by Date, first are the most recent dates
    @Override
    public int compareTo(User obj) {
        if (getDate() == null || obj.getDate() == null)
            return 0;
        return getDate().compareTo(obj.getDate());
    }

}
