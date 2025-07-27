package com.nordcode.bank.account_service.exception;


public class AccountNullException extends RuntimeException {

    public AccountNullException() {
        super("Account is null or does not exist.");
    }

    public AccountNullException(String message) {
        super(message);
    }

    public AccountNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
