package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, columnDefinition = "VARCHAR")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR")
    private String password;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN")
    private boolean is_active;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    @OneToMany(mappedBy = "peminjam")
    List<Transaksi> transaksiPeminjam;

    @OneToMany(mappedBy = "meminjam")
    List<Transaksi> transaksiMeminjam;
}
