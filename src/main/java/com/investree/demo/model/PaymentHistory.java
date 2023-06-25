package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id")
    Transaksi transaksi;
}
