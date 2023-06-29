package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.List;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_peminjam", referencedColumnName = "id")
    Users idPeminjam;

    @ManyToOne
    @JoinColumn(name = "id_meminjam", referencedColumnName = "id")
    Users idMeminjam;

    @Column(name = "tenor")
    private int tenor;

    @Column(name = "total_pinjaman", nullable = false)
    private Double totalPinjaman;

    @Column(name = "bunga_persen", nullable = false)
    private Double bungaPersen;

    @Column(name = "status", columnDefinition = "VARCHAR")
    private String status;
}
