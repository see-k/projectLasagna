package learn.cat.data;

import learn.cat.models.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CatJdbcTemplateRepositoryTest {

    final static int NEXT_CAT_ID = 4;

    @Autowired
    CatJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindGary() {
        Cat actual = repository.findById(3);
        assertNotNull(actual);
        assertEquals(3, actual.getCatId());
        assertEquals("Gary", actual.getName());
    }

    @Test
    void shouldFindAll() {
        List<Cat> cats = repository.findAll();
        assertNotNull(cats);
        assertTrue(cats.size() > 0);
    }

    @Test
    void shouldAddCat() {
        Cat cat = makeCat();
        Cat actual = repository.add(cat);
        assertNotNull(actual);
        assertEquals(4, actual.getCatId());
    }

    @Test
    void shouldUpdateCat() {
        Cat cat = makeCat();
        cat.setCatId(3);
        assertTrue(repository.update(cat));
        cat.setCatId(10);
        assertFalse(repository.update(cat));
    }

    @Test
    void shouldDelete() {
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1));
    }

    private Cat makeCat() {
        Cat cat = new Cat();
        cat.setName("Spongebob");
        cat.setPicture(" ");
        cat.setDesc(" ");
        cat.setDisabled(false);
        cat.setUsersId(3);
        return cat;
    }
}
