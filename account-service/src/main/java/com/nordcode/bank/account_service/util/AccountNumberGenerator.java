package com.nordcode.bank.account_service.util;


import java.security.SecureRandom;

public class AccountNumberGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final int CARD_NUMBER_LENGTH = 16;

    public static String generate() {
        StringBuilder sb = new StringBuilder(CARD_NUMBER_LENGTH);

        // Префікс, наприклад 4 для VISA (можеш замінити або зробити випадковим)
        sb.append("4");

        // Генеруємо решту цифр
        for (int i = 1; i < CARD_NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }
}



