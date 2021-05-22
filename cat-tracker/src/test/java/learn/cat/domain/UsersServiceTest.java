package learn.cat.domain;

import learn.cat.data.UsersRepository;
import learn.cat.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static  org.junit.jupiter.api.Assertions.assertEquals;
import  static  org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersServiceTest {

    @Autowired
    UsersService service;

    @MockBean
    UsersRepository repository;

    @Test
    void shouldDeleteById() {
        when(repository.deleteById(1)).thenReturn(true);
        assertTrue(service.deleteById(1));
    }

    private Users makeUsers() {
        Users users = new Users();
        users.setUsername("Test username");
        users.setFirstName("Hello");
        users.setLastName("World");
        users.setEmail("HWordl@dev-10.com");
        users.setDisabled(false);
        return users;
    }
}