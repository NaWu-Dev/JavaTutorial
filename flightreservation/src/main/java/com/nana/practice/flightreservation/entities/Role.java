package com.nana.practice.flightreservation.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {

    private String name;
    @ManyToMany(mappedBy = "roles")
    public Set<User> getUers() {
        return uers;
    }

    public void setUers(Set<User> uers) {
        this.uers = uers;
    }

    private Set<User> uers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
