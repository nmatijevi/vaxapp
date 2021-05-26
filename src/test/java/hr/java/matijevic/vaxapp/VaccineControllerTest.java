package hr.java.matijevic.vaxapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class VaccineControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    VaccineRepositoryJdbc vaccineRepositoryJdbc;

    @Test
    void getAllVaccine() {
        List<Vaccine> vaccineList = vaccineRepositoryJdbc.findAll();

        Assertions.assertEquals(vaccineList.size(), 4);
    }

    @Test
    void getVaccineByResearchName() {
        Optional<Vaccine> vaccineList = vaccineRepositoryJdbc.findVaccineByResearchName("PF123");
        Vaccine name = vaccineList.get();
        Assertions.assertEquals(name.getResearchName(), "PF123");
    }



    @Test
    void findVaccineInsideVaccineBoundaries() {
    }


}