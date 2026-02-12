package org.example.Interview.db;

import jakarta.persistence.*;

@Entity
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "items")
    private String items;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Resources(String items) {
        this.items = items;
    }
    public Resources() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}