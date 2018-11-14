package com.nana.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accountsystem_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    // serialize Account
    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "accountId"
    )*/
    private List<Account> userAccount;

    public User() {}

    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Account> getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(List<Account> userAccount) {
        this.userAccount = userAccount;
    }
}
