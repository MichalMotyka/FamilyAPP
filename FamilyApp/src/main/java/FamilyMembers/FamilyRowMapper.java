package FamilyMembers;


import Family.Family;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//ResultSet mapper to Family Object
public class FamilyRowMapper implements RowMapper<Family> {
    @Override
    public Family mapRow(ResultSet rs, int rowNum) throws SQLException {
        Family family = new Family(
                rs.getString("familyName"),
                rs.getInt("nrOfAdults"),
                rs.getInt("nrOfChildren"),
                rs.getInt("nrOfinfants"),
                new ArrayList<>(),
                rs.getInt("id"));

        return family;
    }
}
