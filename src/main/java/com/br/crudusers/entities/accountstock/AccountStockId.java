package com.br.crudusers.entities.accountstock;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
public class AccountStockId {

    private UUID accountId;

    private UUID stockId;

    public AccountStockId() {
    }

    public AccountStockId(UUID accountId, UUID stockId) {
        this.accountId = accountId;
        this.stockId = stockId;
    }
}
