package hr.java.matijevic.vaxapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vaccine")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<VaccineDTO> getAllVaccine() {
        return vaccineService.findAll();
    }


    @GetMapping("/{researchName}")
    public VaccineDTO getVaccineByResearchName(@PathVariable String researchName){
        return vaccineService.findVaccineByResearchName(researchName);
    }

    @GetMapping(params = "typeOfVaccine")
    public List<Vaccine> getVaccineByTypeOfVaccine(@RequestParam final String typeOfVaccine){
        return vaccineService.findVaccineByTypeOfVaccine(typeOfVaccine);
    }

    @GetMapping("/vaccineBoundaries/{lower}-{higher}")
    public List<VaccineDTO> findVaccineInsideVaccineBoundaries(@PathVariable String lower, @PathVariable String higher){
        return vaccineService.findVaccineInsideVaccineBoundaries(Integer.parseInt(lower), Integer.parseInt(higher));
    }

    @PostMapping
    public ResponseEntity<VaccineDTO> save(@Valid @RequestBody final VaccineCommand command){
        return vaccineService.save(command)
                .map(
                        vaccineDTO -> ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body(vaccineDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{researchName}")
    public void delete(@PathVariable String researchName){
        vaccineService.deleteByResearchName(researchName);
    }

    @PutMapping("/{manufacturerName}")
    public ResponseEntity<VaccineDTO> update(@PathVariable String manufacturerName, @Valid @RequestBody
    final VaccineCommand updateVaccineCommand){
        return vaccineService.update(manufacturerName, updateVaccineCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }
}