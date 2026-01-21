package org.serhiileniv.banking.model;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void testUserCreation() {
        // Given (що ми маємо)
        UUID id = UUID.randomUUID();
        BigDecimal balance = new BigDecimal("100.00");

        // When (що ми робимо)
        User user = new User(id, balance, "Serhii", "Leniv", "sheruq@mail.com", "123456", "hash");

        // Then (що ми очікуємо)
        assertThat(user.getUserID()).isEqualTo(id);
        assertThat(user.getName()).isEqualTo("Serhii");
        assertThat(user.getBalance()).isEqualTo(balance);
    }
}