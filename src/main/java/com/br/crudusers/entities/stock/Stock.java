package com.br.crudusers.entities.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_stocks")
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID stockId;

    private String description;

    private String ticker;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Stock() {
    }

    public Stock(UUID stockId, String description, String ticker, Instant createdAt, Instant updatedAt) {
        this.stockId = stockId;
        this.description = description;
        this.ticker = ticker;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
