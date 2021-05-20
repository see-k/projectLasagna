package learn.cat.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ReportJdbcTemplateRepositoryTest {

    @Autowired
    ReportJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void findByCatId() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}