package com.nordcode.bank.account_service.exception;


public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id) {
        super("Account with id " + id + " not found");
    }

}
