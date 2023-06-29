package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {
    public Users() {}

    public Users(Long id) {
        this.id = id;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, columnDefinition = "VARCHAR")
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR")
    private String password;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN")
    private boolean is_active;
}
