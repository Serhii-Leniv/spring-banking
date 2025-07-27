package com.nordcode.bank.account_service.service;

import com.nordcode.bank.account_service.dto.AccountCreateRequestDto;
import com.nordcode.bank.account_service.dto.AccountResponseDto;
import com.nordcode.bank.account_service.dto.AccountUpdateRequestDto;
import com.nordcode.bank.account_service.exception.AccountNotFoundException;
import com.nordcode.bank.account_service.exception.AccountNullException;
import com.nordcode.bank.account_service.mapper.AccountMapper;
import com.nordcode.bank.account_service.model.Account;
import com.nordcode.bank.account_service.model.AccountStatus;
import com.nordcode.bank.account_service.repository.AccountRepository;
import com.nordcode.bank.account_service.util.AccountNumberGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImp(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountResponseDto> findAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).toList();
    }

    @Override
    public AccountResponseDto findAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        return accountMapper.toDto(account);
    }

    @Override
    public AccountResponseDto createAccount(AccountCreateRequestDto dto) {
        Account account = accountMapper.toEntity(dto);
        account.setAccountNumber(AccountNumberGenerator.generate());
        Account saved = accountRepository.save(account);
        return accountMapper.toDto(saved);
    }


    @Override
    public AccountResponseDto updateAccount(Long id, AccountUpdateRequestDto dto) {
        Account existing = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        accountMapper.updateEntityFromDto(dto, existing);
        Account updated = accountRepository.save(existing);
        return accountMapper.toDto(updated);
    }

    @Override
    public void deleteAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new AccountNotFoundException(id);
        }
        accountRepository.deleteById(id);
    }

    @Override
    public BigDecimal getAccountBalance(Long id) {
        accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        Account account = accountRepository.findById(id).orElse(null);
        return account.getBalance();
    }

}
