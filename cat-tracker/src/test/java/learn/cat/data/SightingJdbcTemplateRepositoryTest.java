package learn.cat.data;

import learn.cat.models.Cat;
import learn.cat.models.Location;
import learn.cat.models.Sighting;
import learn.cat.models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SightingJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 2;

    @Autowired
    SightingJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }
/*
    @Test
    void shouldFindAll() {
        List<Sighting> sightings = repository.findAll();
        assertNotNull(sightings);
        assertTrue(sightings.size() >= 1 && sightings.size() <= 4);
    }

    @Test
    void shouldFindById() {
        Sighting sighting = repository.findById(1);
        assertNotNull(sighting);
    }

    @Test
    void shouldFindByUser() {
        /*
        assertNotNull(sightings);
        assertEquals(1, sightings.size());*/
    }

    @Test
    void shouldFindByCat() {

    }

    @Test
    void shouldAdd() {
        Sighting sighting = makeSighting();
        Sighting actual = repository.add(sighting);
        assertNotNull(actual);
    }

    @Test
    void shouldUpdate() {
        Sighting sighting = makeSighting();
        sighting.setSightingDescription("UPDATED");
        assertTrue(repository.update(sighting));
    }

    @Test
    void shouldDeleteById() {
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1));
    }

    private Sighting makeSighting() {
        Cat cat = new Cat();
        cat.setCatId(1);
        cat.setName("cat");

        Location location = new Location();
        location.setLocationId(1);
        location.setLatitude(BigDecimal.valueOf(4.823791827));

        Users users = new Users();
        users.setUsersId(1);
        users.setUsername("jnfkjasnd");

        Sighting sighting = new Sighting();
        sighting.setPicture("test img_path");
        sighting.setCatDescription("test visual_description");
        sighting.setSightingDescription("sighting_description");
        sighting.setSightingDate(new Date(2021, 5, 20));
        sighting.setSightingTime(new Time(12, 12, 12));
        sighting.setDisabled(false);
       /* sighting.setUsers(users);
        sighting.setLocation(location);
        sighting.setCat(cat);*/

        return sighting;
    }*/
}