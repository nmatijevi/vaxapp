package hr.java.matijevic.vaxapp.sideEffect;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sideeffect")
@CrossOrigin(origins = "http://localhost:4200")
public class SideEffectController {

    private final SideEffectService sideEffectService;
    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping
    public List<SideEffectDTO> findAll() {
        return sideEffectService.findAll();
    }

   @GetMapping("/{idVaccine}")
    public SideEffectDTO getSideEffectById_vaccine(@PathVariable int idVaccine){
        return sideEffectService.findByIdVaccine(idVaccine);
    }

/*
    @GetMapping("/{shortDescription}")
    public SideEffectDTO getSideEffectByShortDescription(@PathVariable String shortDescription){
        return sideEffectService.findByShortDescription(shortDescription);
    }
 */


}
