package com.nordcode.bank.account_service.dto;


import com.nordcode.bank.account_service.model.AccountType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountCreateRequestDto {

    @NotNull
    private Long userId;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal balance;
    @NotNull
    private AccountType type;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}


