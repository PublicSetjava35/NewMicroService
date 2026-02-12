package org.example.Interview.db;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "local_date_time")
    private LocalDateTime localDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Resources> resourcesList;

    public User(String email, String password, LocalDateTime localDate) {
        this.email = email;
        this.password = password;
        this.localDate = localDate;
    }
    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Resources> getResourcesList() {
        return resourcesList;
    }

    public void setResourcesList(List<Resources> resourcesList) {
        this.resourcesList = resourcesList;
    }
}