package hr.java.matijevic.vaxapp.sideEffect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SideEffectRepositoryTest {

    @Autowired
    SideEffectRepository sideEffectRepository;


    @Test
    void findByShortDescription() {
        Optional<SideEffect> sideEffectSet = sideEffectRepository.findByShortDescription("PF123");

        Assertions.assertNotNull(sideEffectSet);
        Assertions.assertEquals(1, 1);
    }


}