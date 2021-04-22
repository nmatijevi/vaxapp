package hr.java.matijevic.vaxapp;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcVaccineRepository implements VaccineRepositoryJdbc{

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
        values.put("scienceName", vaccine.getScienceName());
        values.put("producerName", vaccine.getProducerName());
        values.put("typeOfVaccine", vaccine.getTypeOfVaccine());
        values.put("availableVaccine", vaccine.getAvailableVaccine());
        values.put("necessaryNumOfVaccine", vaccine.getNecessaryNumOfVaccine());
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
        return jdbc.queryForObject("select id, scienceName, producerName, typeOfVaccine," +
                " necessaryNumOfVaccine, availableVaccine from Vaccines where id = ?", this::mapRowToVaccines, id);
    }

    @Override
    public List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine) {
        return null;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(final String researchName) {
        return Optional.ofNullable(jdbc.queryForObject("Select * from Vaccines where scienceName = ?", this::mapRowToVaccines, researchName));
    }

    @Override
    public boolean deleteByScienceName(String scienceName) {
        String url = "DELETE FROM Vaccines where scienceName = ?";
        Object[] args = new Object[] {scienceName};
        return  jdbc.update("DELETE FROM Vaccines where scienceName = ?",args) == 1;
    }

    @Override
    public List<Vaccine> findVaccineInsideVaccineBoundaries(Integer lowerNum, Integer higherNum) {
        return jdbc.query("select * from Vaccines where availableVaccine between ? and ?", this::mapRowToVaccines,lowerNum, higherNum);
    }


    @Override
    public Optional<Vaccine> update(String producerName, Vaccine vaccine) {
        return Optional.empty();
    }



    private Vaccine mapRowToVaccines(ResultSet rs, int rowNum) throws SQLException{
        Vaccine vaccine = new Vaccine();
        vaccine.setId(rs.getLong("id"));
        vaccine.setScienceName(rs.getString("scienceName"));
        System.out.println(vaccine.getScienceName());
        vaccine.setProducerName(rs.getString("producerName"));
        vaccine.setAvailableVaccine(rs.getInt("availableVaccine"));
        vaccine.setTypeOfVacine(rs.getString("typeOfVaccine"));
        vaccine.setNecessaryNumOfVaccine(rs.getInt("necessaryNumOfVaccine"));
        System.out.println(vaccine.getScienceName());
        return vaccine;
    }
}
