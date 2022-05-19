package com.example.demo.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "exchange_table")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "currency_value")
    private BigDecimal value;
    private int userId;

}
