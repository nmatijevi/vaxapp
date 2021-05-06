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

 /*  @GetMapping("/{idVaccine}")
    public SideEffectDTO getSideEffectById_vaccine(@PathVariable int idVaccine){
        return sideEffectService.findByIdVaccine(idVaccine);
    }

  */


    @GetMapping("/{shortDescription}")
    public SideEffectDTO getSideEffectByShortDescription(@PathVariable String shortDescription){
        return sideEffectService.findByShortDescription(shortDescription);
    }


     @GetMapping("/searchByScienceName/{scienceName}")
     public SideEffectDTO getSideEffectByScienceName(@PathVariable String scienceName){
         return sideEffectService.findByScienceName(scienceName);
 }



    @GetMapping("/frequency/{from}-{to}")
    public List<SideEffectDTO> findAllByPercentageOfEffectBetween(@PathVariable String from, @PathVariable String to){
        return sideEffectService.findAllByPercentageOfEffectBetween(Integer.parseInt(from), Integer.parseInt(to));
    }


}
