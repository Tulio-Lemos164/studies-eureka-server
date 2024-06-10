package br.com.mscards.model;

import br.com.mscards.model.enums.Brand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data @NoArgsConstructor
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "income", nullable = false)
    private BigDecimal income;

    @Column(name = "basicLimit", nullable = false)
    private BigDecimal basicLimit;

    public Card(String name, Brand brand, BigDecimal income, BigDecimal basicLimit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}
