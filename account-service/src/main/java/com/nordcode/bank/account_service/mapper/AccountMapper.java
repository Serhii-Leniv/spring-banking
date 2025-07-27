package com.nordcode.bank.account_service.mapper;

import com.nordcode.bank.account_service.dto.AccountResponseDto;
import com.nordcode.bank.account_service.model.Account;
import com.nordcode.bank.account_service.dto.AccountCreateRequestDto;
import com.nordcode.bank.account_service.dto.AccountUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountCreateRequestDto dto);
    AccountResponseDto toDto(Account account);

    void updateEntityFromDto(AccountUpdateRequestDto dto, @MappingTarget Account account);
}
