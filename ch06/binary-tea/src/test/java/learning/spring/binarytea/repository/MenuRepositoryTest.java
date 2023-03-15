package learning.spring.binarytea.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    void testCountMenuItems() {
        Assertions.assertEquals(2,menuRepository.countMenuItems());
    }
}
