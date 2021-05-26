package hr.java.matijevic.vaxapp.sideEffect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SideEffectControllerTest {

    @Autowired
    SideEffectService sideEffectService;


    @Test
    void findAll() {

    }

    @Test
    void getSideEffectByShortDescription() {

    }

    @Test
    void getSideEffectByResearchName() {

    }

    @Test
    void findAllByFrequencyBetween() {
    }
}