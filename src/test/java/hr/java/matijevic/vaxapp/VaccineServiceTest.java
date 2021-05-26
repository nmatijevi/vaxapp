package hr.java.matijevic.vaxapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VaccineServiceTest {

    @Autowired
    VaccineRepositoryJdbc vaccineRepositoryJdbc;

    @Autowired
    VaccineService vaccineService;

    @Test
    void findAll() {
        List<Vaccine> vaccineList = vaccineRepositoryJdbc.findAll();

        Assertions.assertEquals(vaccineList.size(), 4);
    }

    @Test
    void findVaccineByResearchName() {
        Optional<Vaccine> vaccineList = vaccineRepositoryJdbc.findVaccineByResearchName("PF123");
        Vaccine name = vaccineList.get();
        Assertions.assertEquals(name.getResearchName(), "PF123");
    }

    @Test
    void findVaccineByTypeOfVaccine() {
    }



    @Test
    void deleteByResearchName() {
    }

}