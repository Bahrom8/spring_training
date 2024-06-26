package com.example.entity;

import com.example.enums.Status;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "payment_detail_id") //default name
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

}
