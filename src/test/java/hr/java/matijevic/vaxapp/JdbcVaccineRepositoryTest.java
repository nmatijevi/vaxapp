package hr.java.matijevic.vaxapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcVaccineRepositoryTest {

    @Autowired
    VaccineRepositoryJdbc vaccineRepositoryJdbc;

    @Test
    void findAll() {
        List<Vaccine> vaccineList = vaccineRepositoryJdbc.findAll();
        Assertions.assertEquals(vaccineList.size(), 4);
    }

    @Test
    void save() {
    }

    @Test
    void findOne() {
    }

    @Test
    void findVaccineByTypeOfVaccine() {
    }

    @Test
    void findVaccineByResearchName() {
    }

    @Test
    void deleteByScienceName() {
    }

    @Test
    void findVaccineInsideVaccineBoundaries() {
    }

    @Test
    void update() {
    }
}