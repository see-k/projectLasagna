package learn.cat.data;

import learn.cat.models.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LocationJdbcTemplateRepositoryTest {

    final static int NEXT_LOCATION_ID = 4;

    @Autowired
    LocationJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindById() {
        Location actual = repository.findById(1);
        assertNotNull(actual);
        assertEquals(1, actual.getLocationId());
        assertEquals(BigDecimal.valueOf( 44.943687), actual.getLatitude());
    }

    //TODO pending delete
    @Test
    void findAllByCat() {
    }

    @Test
    void shouldAdd() {
        Location location = makeLocation();
        Location actual = repository.add(location);
        assertNotNull(actual);
        assertEquals(NEXT_LOCATION_ID, actual.getLocationId());
    }

    @Test
    void shouldUpdate() {
        Location location = makeLocation();
        location.setLocationId(NEXT_LOCATION_ID - 1);
        assertTrue(repository.update(location));
        location.setLocationId(NEXT_LOCATION_ID+10);
        assertFalse(repository.update(location));
    }

    @Test
    void deleteById() {
        assertTrue(repository.deleteById(NEXT_LOCATION_ID));
        assertFalse(repository.deleteById(NEXT_LOCATION_ID+10));
    }

    Location makeLocation() {
        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(33.333333));
        location.setLongitude(BigDecimal.valueOf(-93.999999));
        return location;
    }
}