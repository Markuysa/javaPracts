package com.example.task11;

import com.example.task11.Entities.User;
import com.example.task11.Repository.UsersRepository;
import com.example.task11.Services.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Captor
    ArgumentCaptor<User> captor;

    @Mock
    private UsersRepository userRepo;
    @Mock
    private BCryptPasswordEncoder encoder;

    @Test
    void addUser() {

        UsersService service = new UsersService(userRepo);
        service.addUser("Someone", "somepassword");
        Mockito.verify(userRepo).save(captor.capture());

        User captured = captor.getValue();

        Assertions.assertEquals("Someone", captured.getUsername());
        Assertions.assertEquals("somepassword",
                captured.getPassword());
    }

}
