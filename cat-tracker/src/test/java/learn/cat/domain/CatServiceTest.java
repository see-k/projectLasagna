package learn.cat.domain;


import learn.cat.data.CatRepository;
import learn.cat.models.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CatServiceTest {

    @Autowired
    CatService service;

    @MockBean
    CatRepository repository;

    @Test
    void shouldFindAllCats() {
        Cat cat = makeCat();
        cat.setCatId(1);
        List<Cat> actual = new ArrayList<>();
        actual.add(cat);
        when(repository.findAll()).thenReturn(actual);
        assertEquals(1, actual.size());
    }

    @Test
    void shouldFindPatrick() {
        Cat expected = makeCat();
        expected.setCatId(1);
        when(repository.findById(1)).thenReturn(expected);
        Cat actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        Cat cat = makeCat();
        Cat mockOut = makeCat();
        mockOut.setCatId(1);

        when(repository.add(cat)).thenReturn(mockOut);

        Result<Cat> actual = service.add(cat);
        assertEquals(ResultType.SUCCESS, actual.getType());
        assertEquals(mockOut, actual.getPayload());
    }

    @Test
    void shouldNotAdd() {
        Cat cat = makeCat();
        cat.setCatId(1);

        Result<Cat> actual = service.add(cat);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("`add`"));
    }

    @Test
    void shouldUpdate() {
        Cat cat = makeCat();
        cat.setCatId(1);

        when(repository.update(cat)).thenReturn(true);

        Result<Cat> actual = service.update(cat);
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

    Cat makeCat() {
        //('Patrick', 'Test Description', 'Test Image Path', '1', 'false',)
        Cat cat = new Cat();
        cat.setName("Patrick");
        cat.setDesc("Test Description");
        cat.setPicture("Test Image Path");
        cat.setUsersId(1);
        cat.setDisabled(false);
        return cat;
    }
}
