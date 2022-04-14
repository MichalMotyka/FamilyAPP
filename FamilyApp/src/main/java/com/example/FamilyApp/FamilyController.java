package com.example.FamilyApp;

import DateValidate.FamilyData;
import Family.Family;
import FamilyMembers.FamilyRowMapper;
import FamilyMembers.JSONFamilymember;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class FamilyController {


    @RequestMapping(method = RequestMethod.POST, value = "/CreateFamily")
    public Object CreateFamily(@RequestBody Family family) throws IOException {
        String SQL = "SELECT MAX(id) FROM Family";
        int valid = FamilyData.validateFamilyData(family.getFamilyMember(), family.getNrOfInfants(), family.getNrOfChildren(), family.getNrOfAdults());
        if (valid == 1) {
            return new ResponseEntity<>("Data of family is not compatible with age of members", HttpStatus.EXPECTATION_FAILED);
        } else if (valid == 2) {
            return new ResponseEntity<>("Age cannot be smaller then 0", HttpStatus.EXPECTATION_FAILED);
        }
        JSONFamilymember jfm = new JSONFamilymember();
        SqlRowSet rs = Config.getJdbcTemplate().queryForRowSet(SQL);
        int id = 0;
        if (rs.next()) {
            id = rs.getInt("MAX(id)") + 1;
        }
        SQL = "Insert into Family values('" + family.getFamilyName() + "'," + id + "," + family.getNrOfAdults() + ","
                + family.getNrOfChildren() + "," + family.getNrOfInfants() + ")";
        for (int x = 0; x <= family.getFamilyMember().size() - 1; x++) {
            jfm.registerMember(family.getFamilyMember().get(x), id);
        }
        Config.getJdbcTemplate().update(SQL);
        return id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getFamily")
    public Object getFamily(@RequestBody Family family) throws IOException {
        String SQL = "Select * from Family WHERE id  =" + family.getId();
        Gson gson = new Gson();
        String id = JSONFamilymember.getID(family.getId());
        String response = gson.toJson(Config.getJdbcTemplate().queryForObject(SQL, new FamilyRowMapper()));
        response = response.replace("[]", JSONFamilymember.searchFamilyMember(id));
        return response;
    }
}
