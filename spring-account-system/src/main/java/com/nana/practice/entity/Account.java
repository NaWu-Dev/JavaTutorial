package com.nana.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "accountsystem_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int accountId;

    @Column(name = "account")
    private String accountName;

    @Column(name = "password")
    private String password;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    // @JsonBackReference
    // serialize User
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "userId"
    )
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hostId")
    // @JsonBackReference
    // serialize host
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "hostId"
    )
    private Host host;

    public Account() {}

    public Account(String accountName, String password, String comment, User user, Host host) {
        this.accountName = accountName;
        this.password = password;
        this.comment = comment;
        this.user = user;
        this.host = host;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                ", host=" + host +
                '}';
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
}
