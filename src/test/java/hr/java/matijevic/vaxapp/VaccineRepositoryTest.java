package hr.java.matijevic.vaxapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class VaccineRepositoryTest {

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






}