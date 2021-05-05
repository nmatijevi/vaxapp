package hr.java.matijevic.vaxapp;

import hr.java.matijevic.vaxapp.sideEffect.SideEffect;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcVaccineRepository implements VaccineRepositoryJdbc {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert vaccineInserter;

    public JdbcVaccineRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.vaccineInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Vaccines")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Vaccine> findAll() {
        return jdbc.query("select * from Vaccines", this::mapRowToVaccines);

    }


    private long saveVaccineDetails(Vaccine vaccine){
        Map<String, Object> values = new HashMap<>();
        values.put("science_name", vaccine.getScienceName());
        values.put("producer_name", vaccine.getProducerName());
        values.put("type_vaccine", vaccine.getTypeOfVaccine());
        values.put("available_vaccine", vaccine.getAvailableVaccine());
        values.put("necessary_vaccine", vaccine.getNecessaryNumOfVaccine());
        System.out.println(vaccine.getScienceName());
        System.out.println(vaccine.getProducerName());
        return vaccineInserter.executeAndReturnKey(values).longValue();
    }
    @Override
    public Optional<Vaccine> save(final Vaccine vaccine) {
            vaccine.setId(saveVaccineDetails(vaccine));
            return Optional.of(vaccine);
    }


    @Override
    public Vaccine findOne(Integer id) {
        return jdbc.queryForObject("select id, science_name, producer_name, type_vaccine," +
                " necessary_vaccine, available_vaccine from Vaccines where id = ?", this::mapRowToVaccines, id);
    }

    @Override
    public List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine) {
        return null;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(final String researchName) {
        return Optional.ofNullable(jdbc.queryForObject("Select * from Vaccines where science_name = ?", this::mapRowToVaccines, researchName));
    }

    @Override
    public boolean deleteByScienceName(String scienceName) {
        String url = "DELETE FROM Vaccines where science_name = ?";
        Object[] args = new Object[] {scienceName};
        return  jdbc.update("DELETE FROM Vaccines where science_name = ?",args) == 1;
    }

    @Override
    public List<Vaccine> findVaccineInsideVaccineBoundaries(Integer lowerNum, Integer higherNum) {
        return jdbc.query("select * from Vaccines where available_vaccine between ? and ?", this::mapRowToVaccines,lowerNum, higherNum);
    }


    @Override
    public Optional<Vaccine> update(String producerName, Vaccine vaccine) {
        return Optional.empty();
    }



    private Vaccine mapRowToVaccines(ResultSet rs, int rowNum) throws SQLException{
        Vaccine vaccine = new Vaccine();
        vaccine.setId(rs.getLong("id"));
        vaccine.setScienceName(rs.getString("science_name"));
        vaccine.setProducerName(rs.getString("producer_name"));
        vaccine.setAvailableVaccine(rs.getInt("available_vaccine"));
        vaccine.setTypeOfVacine(rs.getString("type_vaccine"));
        vaccine.setNecessaryNumOfVaccine(rs.getInt("necessary_vaccine"));
        return vaccine;
    }
}
