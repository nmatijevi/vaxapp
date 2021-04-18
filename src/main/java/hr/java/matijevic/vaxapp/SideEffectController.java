package hr.java.matijevic.vaxapp;

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
    public List<SideEffectDTO> getAllSideEffect() {
        return sideEffectService.findAll();
    }


    @GetMapping("/{shortDescription}")
    public SideEffectDTO getSideEffectByShortDescription(@PathVariable String shortDescription){
        return sideEffectService.findSideEffectByShortDescription(shortDescription);
    }
}
