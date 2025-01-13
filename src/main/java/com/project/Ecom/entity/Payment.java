package com.project.Ecom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private int totalAmount;

    private String Status;

    @OneToOne(mappedBy = "payment", targetEntity = OrderRecord.class)
    private OrderRecord orderRecord;


}
