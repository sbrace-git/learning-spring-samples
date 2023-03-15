package learning.spring.binarytea.repository;

import learning.spring.binarytea.model.MenuItem;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    @Order(0)
    void testCountMenuItems() {
        assertEquals(2, menuRepository.countMenuItems());
    }

    @Test
    @Order(0)
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
    @Order(0)
    void testQueryForItem() {
        MenuItem menuItem = menuRepository.queryForItem(1L);
        assertItem(menuItem, 1L, "Java咖啡", "中杯", BigDecimal.valueOf(10.00d));
    }

    @Test
    @Order(1)
    void testInsertItem() {
        MenuItem item = MenuItem.builder()
                .name("Go橙汁").size("中杯")
                .price(BigDecimal.valueOf(12.00d))
                .build();
        assertEquals(1, menuRepository.insertItem(item));
        assertNull(item.getId());
        MenuItem queryItem = menuRepository.queryForItem(3L);
        assertItem(queryItem, 3L, "Go橙汁", "中杯", BigDecimal.valueOf(12.00));

        // fill id
        assertEquals(1, menuRepository.insertItemAndFillId(item));
        assertNotNull(item.getId());
        queryItem = menuRepository.queryForItem(item.getId());
        assertItem(queryItem, 4L, "Go橙汁", "中杯", BigDecimal.valueOf(12.00));
    }

    @Test
    @Order(3)
    void testInsertItemWithNamedParameter() {
        MenuItem item = MenuItem.builder()
                .name("Go橙汁").size("中杯")
                .price(BigDecimal.valueOf(12.00d))
                .build();
        assertEquals(1, menuRepository.insertItemWithNamedParameter(item));
        assertNull(item.getId());
        MenuItem queryItem = menuRepository.queryForItem(5L);
        assertItem(queryItem, 5L, "Go橙汁", "中杯", BigDecimal.valueOf(12.00));

        // fill id
        assertEquals(1, menuRepository.insertItemAndFillIdWithNamedParameter(item));
        assertNotNull(item.getId());
        queryItem = menuRepository.queryForItem(item.getId());
        assertItem(queryItem, 6L, "Go橙汁", "中杯", BigDecimal.valueOf(12.00));
    }

    @Test
    @Order(4)
    void testDelete() {
        assertEquals(1, menuRepository.deleteItem(3L));
        assertEquals(1, menuRepository.deleteItem(2L));
    }
}
