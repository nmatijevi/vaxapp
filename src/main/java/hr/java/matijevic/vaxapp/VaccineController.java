package hr.java.matijevic.vaxapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping("/{scienceName}")
    public VaccineDTO getVaccineByResearchName(@PathVariable String scienceName){
        return vaccineService.findVaccineByResearchName(scienceName);
    }

    List<VaccineService> listOfVaccineServices = new ArrayList<>();

    @GetMapping(params = "typeOfVaccine")
    public List<Vaccine> getVaccineByTypeOfVaccine(@RequestParam final String typeOfVaccine){
        return vaccineService.findVaccineByTypeOfVaccine(typeOfVaccine);
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
    @DeleteMapping("/{scienceName}")
    public void delete(@PathVariable String scienceName){
        vaccineService.deleteByScienceName(scienceName);
    }

    @PutMapping("/{producerName}")
    public ResponseEntity<VaccineDTO> update(@PathVariable String producerName, @Valid @RequestBody
    final VaccineCommand updateVaccineCommand){
        return vaccineService.update(producerName, updateVaccineCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }


}