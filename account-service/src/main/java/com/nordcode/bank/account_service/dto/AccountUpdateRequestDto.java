package com.nordcode.bank.account_service.dto;

import com.nordcode.bank.account_service.model.AccountStatus;
import com.nordcode.bank.account_service.model.AccountType;

public class AccountUpdateRequestDto {
    private AccountStatus status;
    private AccountType type;


    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
