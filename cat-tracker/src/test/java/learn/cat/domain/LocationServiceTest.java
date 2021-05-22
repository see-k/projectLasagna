package learn.cat.domain;

import learn.cat.data.LocationRepository;
import learn.cat.models.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import static  org.junit.jupiter.api.Assertions.assertEquals;
import  static  org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LocationServiceTest {

    @Autowired
    LocationService service;

    @MockBean
    LocationRepository repository;

    @Test
    void findById() {
        Location expected = makeLocation();
        when(repository.findById(1)).thenReturn(expected);
        Location actual = service.findById(1);
        assertEquals(expected, actual);
    }

    Location makeLocation() {
        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(33.333333));
        location.setLongitude(BigDecimal.valueOf(-93.999999));
        return location;
    }
}