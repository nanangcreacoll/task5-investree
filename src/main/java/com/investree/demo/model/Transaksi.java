package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

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
    Users peminjam;

    @ManyToOne
    @JoinColumn(name = "id_meminjam", referencedColumnName = "id")
    Users meminjam;

    @Column(name = "tenor")
    private int tenor;

    @Column(name = "total_pinjaman", nullable = false)
    private Double totalPinjaman;

    @Column(name = "bunga_persen", nullable = false)
    private Double bungaPersen;

    @Column(name = "status", columnDefinition = "VARCHAR")
    private String status;

    @OneToMany(mappedBy = "transaksi")
    private Set<PaymentHistory> paymentHistories = new LinkedHashSet<>();
}
