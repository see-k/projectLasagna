package learn.cat.domain;

import learn.cat.data.SightingRepository;
import learn.cat.models.Sighting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SightingServiceTest {

    @Autowired
    SightingService service;

    @MockBean
    SightingRepository repository;

    @Test
    void shouldFindById() {
        Sighting expected = makeSighting();
        expected.setSightingId(1);
        when(repository.findById(1)).thenReturn(expected);
        Sighting actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByUsersId() {
        Sighting sighting = makeSighting();
        List<Sighting> expected = new ArrayList<>();
        expected.add(sighting);
        when(repository.findByUsersId(1)).thenReturn(expected);
        List<Sighting> actual = service.findByUsersId(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByCatId() {
        Sighting sighting = makeSighting();
        List<Sighting> expected = new ArrayList<>();
        expected.add(sighting);
        when(repository.findByCatId(1)).thenReturn(expected);
        List<Sighting> actual = service.findByCatId(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        Sighting sightingIn = makeSighting();
        Sighting sightingOut = makeSighting();
        sightingOut.setSightingId(1);

        when(repository.add(sightingIn)).thenReturn(sightingOut);

        Result<Sighting> result = service.add(sightingIn);
        assertEquals(ResultType.SUCCESS, result.getType());
        assertEquals(sightingOut, result.getPayload());
    }

    @Test
    void shouldNotAddSetId() {
        Sighting sightingIn = makeSighting();
        sightingIn.setSightingId(2);
        Result<Sighting> result = service.add(sightingIn);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    @Test
    void shouldNotAddNullSighting() {
        Result<Sighting> result = service.add(null);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }


    @Test
    void shouldUpdate() {
        Sighting sighting = makeSighting();
        sighting.setSightingId(1);

        when(repository.update(sighting)).thenReturn(true);

        Result<Sighting> actual = service.update(sighting);
        assertEquals(ResultType.SUCCESS, actual.getType());
    }

    @Test
    void shouldNotUpdateNullId() {
        Sighting sighting = makeSighting();
        Result<Sighting> result = service.update(sighting);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    @Test
    void shouldNotUpdateNullSighting() {
        Result<Sighting> result = service.update(null);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    @Test
    void shouldDeleteById() {
        when(repository.deleteById(1)).thenReturn(true);
        assertTrue(service.deleteById(1));
    }

    @Test
    void shouldNotDeleteById() {
        when(repository.deleteById(10)).thenReturn(false);
        assertFalse(service.deleteById(10));
    }

    private Sighting makeSighting() {
        Sighting sighting = new Sighting();
        sighting.setPicture("test img_path");
        sighting.setCatDescription("test visual_description");
        sighting.setSightingDescription("sighting_description");
        sighting.setSightingDate(new Date(2021, 5, 20));
        sighting.setSightingTime(new Time(12, 12, 12));
        sighting.setLatitude(new BigDecimal("44.943687"));
        sighting.setLongitude(new BigDecimal("-93.296228"));
        sighting.setDisabled(false);
        sighting.setCatId(1);
        sighting.setUsersId(1);
        return sighting;
    }
}