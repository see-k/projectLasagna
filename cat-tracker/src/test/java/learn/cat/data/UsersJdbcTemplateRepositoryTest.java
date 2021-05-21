package learn.cat.data;

import learn.cat.models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 4;

    @Autowired
    UsersJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() { knownGoodState.set(); }

    @Test
    void shouldFindAll() {
        List<Users> users = repository.findAll();
        assertNotNull(users);
        assertEquals(4, users.size());
    }

    @Test
    void shouldFindById() {
        Users actual = repository.findById(1);
        assertEquals("chike", actual.getFirstName().toLowerCase(Locale.ROOT));
        assertEquals("okonta", actual.getLastName().toLowerCase(Locale.ROOT));
    }

    @Test
    void shouldAdd() {
        Users users = makeUsers();
        Users actual = repository.add(users);
        assertNotNull(actual);
        assertEquals(NEXT_ID, actual.getUsersId());
    }

    @Test
    void shouldUpdate() {
        Users users = makeUsers();
        users.setUsersId(NEXT_ID - 1);
        assertTrue(repository.update(users));
        users.setUsersId(NEXT_ID+10);
        assertFalse(repository.update(users));
    }

    //TODO Failed test
    @Test
    void deleteById() {
        assertTrue(repository.deleteById(NEXT_ID-2));
        assertFalse(repository.deleteById(NEXT_ID+10));
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