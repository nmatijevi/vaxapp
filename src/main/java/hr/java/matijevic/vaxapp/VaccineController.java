package hr.java.matijevic.vaxapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<VaccineDTO> getAllVaccine() {
        return vaccineService.findAll();
    }


    @GetMapping(params = "researchName")
    public VaccineDTO getVaccineByResearchName(@RequestParam final String researchName){
        return vaccineService.findVaccineByResearchName(researchName);
    }

    List<VaccineService> listOfVaccineServices = new ArrayList<>();

    @GetMapping(params = "typeOfVaccine")
    public VaccineDTO getVaccineByTypeOfVaccine(@RequestParam final String typeOfVaccine){
        return vaccineService.findVaccineByTypeOfVaccine(typeOfVaccine);
    }
}