package learning.spring.binarytea.repository;

import learning.spring.binarytea.model.MenuItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class MenuRepository {
    private JdbcTemplate jdbcTemplate;

    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long countMenuItems() {
        return jdbcTemplate.queryForObject("select count(*) from t_menu", Long.class);
    }

    public MenuItem queryForItem(Long id) {
        return jdbcTemplate.queryForObject("select * from t_menu where id = ?", rowMapper(), id);
    }

    private RowMapper<MenuItem> rowMapper() {
        return (rs, rowNum) -> MenuItem.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .size(rs.getString("size"))
                .price(BigDecimal.valueOf(rs.getLong("price") / 100.0d))
                .createTime(new Date(rs.getDate("create_time").getTime()))
                .updateTime(new Date(rs.getDate("update_time").getTime()))
                .build();
    }

    public List<MenuItem> queryAllItems() {
        return jdbcTemplate.query("select * from t_menu", rowMapper());
    }

    public static final String INSERT_SQL =
            "insert into t_menu (name, size, price, create_time, update_time) values (?, ?, ?, now(), now())";

    public int insertItem(MenuItem item) {
        return jdbcTemplate.update(INSERT_SQL, item.getName(), item.getSize(),
                item.getPrice().multiply(BigDecimal.valueOf(100)).longValue());
    }

    public int insertItemAndFillId(MenuItem item) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        int affected = jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getSize());
            preparedStatement.setLong(3, item.getPrice().multiply(BigDecimal.valueOf(100)).longValue());
            return preparedStatement;
        }, generatedKeyHolder);

        if (affected == 1) {
            item.setId(Objects.requireNonNull(generatedKeyHolder.getKey()).longValue());
        }

        return affected;
    }

    public int deleteItem(Long id) {
        return jdbcTemplate.update("delete from t_menu where id = ?", id);
    }
}
