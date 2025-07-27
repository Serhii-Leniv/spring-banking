package com.nordcode.bank.account_service.service;

import com.nordcode.bank.account_service.dto.AccountCreateRequestDto;
import com.nordcode.bank.account_service.dto.AccountResponseDto;
import com.nordcode.bank.account_service.dto.AccountUpdateRequestDto;
import com.nordcode.bank.account_service.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    List<AccountResponseDto> findAllAccounts();
    AccountResponseDto findAccountById(Long id);
    AccountResponseDto createAccount(AccountCreateRequestDto dto);
    AccountResponseDto updateAccount(Long id, AccountUpdateRequestDto dto);
    void deleteAccount(Long id);
    BigDecimal getAccountBalance(Long id);

}
