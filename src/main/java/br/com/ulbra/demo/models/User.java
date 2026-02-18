package br.com.ulbra.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users") 
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(min = 2, max = 100)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(min = 5, max = 100)
    private String email;

    @Column(length = 100, nullable = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(min = 6, max = 100)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
