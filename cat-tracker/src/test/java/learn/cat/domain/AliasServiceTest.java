package learn.cat.domain;


import learn.cat.data.AliasRepository;
import learn.cat.models.Alias;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AliasServiceTest {

    @Autowired
    AliasService service;

    @MockBean
    AliasRepository repository;

    @Test
    void shouldFindStar() {
        Alias expected = makeAlias();
        expected.setAliasId(1);
        when(repository.findById(1)).thenReturn(expected);
        Alias actual = service.findById(1);
        assertEquals(expected, actual);

    }

    @Test
    void shouldAdd() {
        Alias alias = makeAlias();
        Alias mockOut = makeAlias();
        mockOut.setAliasId(1);

        when(repository.add(alias)).thenReturn(mockOut);

        Result<Alias> actual = service.add(alias);
        assertEquals(ResultType.SUCCESS, actual.getType());
        assertEquals(mockOut, actual.getPayload());
    }

    @Test
    void shouldNotAdd() {
        Alias alias = makeAlias();
        alias.setAliasId(1);

        Result<Alias> actual = service.add(alias);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("`add`"));
    }

    @Test
    void shouldUpdate() {
        Alias alias = makeAlias();
        alias.setAliasId(1);

        when(repository.update(alias)).thenReturn(true);

        Result<Alias> actual = service.update(alias);
        assertEquals(ResultType.SUCCESS, actual.getType());
    }

    @Test
    void shouldDelete() {
        when(repository.deleteById(1)).thenReturn(true);
        assertTrue(service.deleteById(1));
    }

    @Test
    void shouldNotDelete() {
        when(repository.deleteById(10)).thenReturn(false);
        assertFalse(service.deleteById(10));
    }

    Alias makeAlias() {
        Alias alias = new Alias();
        alias.setAliasName("Star");
        alias.setCatId(1);
        return alias;
    }
}
