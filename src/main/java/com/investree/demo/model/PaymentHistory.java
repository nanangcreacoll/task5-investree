package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pembayaran_ke", nullable = false)
    private int pembayaran_ke;

    @Column(name = "jumlah", nullable = false)
    private Double jumlah;

    @Column(name = "bukti_pembayaran", columnDefinition = "VARCHAR")
    private String bukti_pembayaran;

    @OneToMany
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id")
    private List<Transaksi> transaksi;
}
