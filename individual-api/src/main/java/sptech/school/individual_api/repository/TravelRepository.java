package sptech.school.individual_api.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sptech.school.individual_api.exception.DataBaseAccessException;
import sptech.school.individual_api.model.Travels;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TravelRepository {

    private final JdbcTemplate jdbcTemplate;

    public TravelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer save(Travels travel) {
        String sql = "INSERT INTO Travels (destination, departure, companions, memories) VALUES (?, ?, ?, ?)";
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, travel.getDestination());
                ps.setObject(2, travel.getDeparture());
                ps.setString(3, travel.getCompanions());
                ps.setString(4, travel.getMemories());
                return ps;
            }, keyHolder);

            Number key = keyHolder.getKey();
            return key != null ? key.intValue() : null;
        } catch (DataAccessException e) {
            throw new DataBaseAccessException("Error registering the travel", e);
        }
    }

    public List<Travels> getAllTravels() {
        String sql = "SELECT * FROM Travels";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Travels.class));
        } catch (DataAccessException e) {
            throw new DataBaseAccessException("Error retrieving the travels", e);
        }
    }
}