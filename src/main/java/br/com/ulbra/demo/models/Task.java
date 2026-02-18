package br.com.ulbra.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    public interface CreateTask {}
    public interface UpdateTask {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    @NotNull(groups = CreateTask.class)
    @NotEmpty(groups = CreateTask.class)
    @Size(min = 1, max = 255)
    private String description;

    @Column(nullable = false)
    private Boolean done = false;

    // 🔗 relacionamento com usuário
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Task() {}

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDone() {
        return done;
    }

    public User getUser() {
        return user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
