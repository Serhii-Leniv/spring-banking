package org.serhiileniv.banking.service;

import org.serhiileniv.banking.dto.TransactionRequest;
import org.serhiileniv.banking.model.Transaction;
import org.serhiileniv.banking.repository.TransactionRepository;
import org.serhiileniv.banking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository){
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }



}
