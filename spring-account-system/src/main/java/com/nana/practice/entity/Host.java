package com.nana.practice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accountsystem_host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hostId;

    @Column(name = "host_name")
    private String hostName;

    @Column(name = "host_desc")
    private String hostDescription;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JsonManagedReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "accountId"
    )
    private List<Account> hostAccount;

    public List<Account> getHostAccount() {
        return hostAccount;
    }

    public void setHostAccount(List<Account> hostAccount) {
        this.hostAccount = hostAccount;
    }

    public Host() {}

    @Override
    public String toString() {
        return "Host{" +
                "hostId=" + hostId +
                ", hostName='" + hostName + '\'' +
                ", hostDescription='" + hostDescription + '\'' +
                '}';
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostDescription() {
        return hostDescription;
    }

    public void setHostDescription(String hostDescription) {
        this.hostDescription = hostDescription;
    }

    public Host(String hostName, String hostDescription) {
        this.hostName = hostName;
        this.hostDescription = hostDescription;
    }
}
