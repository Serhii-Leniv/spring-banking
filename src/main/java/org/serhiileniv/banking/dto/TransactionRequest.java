package org.serhiileniv.banking.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequest(
        UUID receiverId,
        UUID senderId,
        BigDecimal amount
) {}

