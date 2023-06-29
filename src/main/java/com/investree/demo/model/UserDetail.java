package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_detail")
public class UserDetail implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Users idUser;

    @Column(name = "nama", nullable = false, columnDefinition = "VARCHAR")
    private String nama;

    @Column(name = "alamat", columnDefinition="TEXT")
    private String alamat;
}
