package br.com.iDantas.wallet_core_api.service;


import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.dto.UsersRequest;
import br.com.iDantas.wallet_core_api.enums.ClientType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should create User successfully")
    void testCreateUser() {
        UsersRequest user = new UsersRequest("123","Iago", "444", "test@gmail.com", "12345678911", ClientType.COMMOM, new BigDecimal(10));
        when(usersRepository.existsByUsername(any())).thenReturn(Boolean.FALSE);
        when(usersRepository.existsByEmail(any())).thenReturn(Boolean.FALSE);
        when(usersRepository.existsByCpf(any())).thenReturn(Boolean.FALSE);
        when(usersRepository.save(any())).thenReturn(user);
        UsersRequest result = userService.createUser(user);

        assertAll(
                () -> assertEquals("Iago", result.getUsername()),
                () -> assertEquals("444", result.getPassword()),
                () -> assertEquals("test@gmail.com", result.getEmail()));
    }
}