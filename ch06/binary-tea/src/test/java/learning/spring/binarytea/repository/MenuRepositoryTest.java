package learning.spring.binarytea.repository;

import learning.spring.binarytea.model.MenuItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    void testCountMenuItems() {
        assertEquals(2, menuRepository.countMenuItems());
    }

    @Test
    void testQueryAllItems() {
        List<MenuItem> menuItems = menuRepository.queryAllItems();
        assertNotNull(menuItems);
        assertFalse(menuItems.isEmpty());
        assertEquals(2, menuItems.size());
    }

    private void assertItem(MenuItem item, Long id, String name, String size, BigDecimal price) {
        assertNotNull(item);
        assertEquals(id, item.getId());
        assertEquals(name, item.getName());
        assertEquals(size, item.getSize());
        assertEquals(price, item.getPrice());
    }

    @Test
    void testQueryForItem() {
        MenuItem menuItem = menuRepository.queryFotItem(1L);
        assertItem(menuItem, 1L, "Java咖啡", "中杯", BigDecimal.valueOf(10.00d));
    }
}
