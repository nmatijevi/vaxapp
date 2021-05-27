package hr.java.matijevic.vaxapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

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



    @Test
    void update() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        VaccineCommand vaccineCommand = new VaccineCommand();
        vaccineCommand.setResearchName("researchName");
        vaccineCommand.setManufacturerName("manufacturerName");
        vaccineCommand.setType("");
        vaccineCommand.setNumberOfShots(1);
        vaccineCommand.setAvailableDoses(1512);

        this.mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.
                        put("/vaccine/" + "researchName").
                        with(user("admin").password("user").roles("ADMIN")).with(csrf()).
                        contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(vaccineCommand))
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    }
