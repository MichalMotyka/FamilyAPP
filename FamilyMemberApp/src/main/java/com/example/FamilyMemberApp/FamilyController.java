package com.example.FamilyMemberApp;

import com.google.gson.Gson;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FamilyController {

    @RequestMapping(method = RequestMethod.POST, value = "/createFamilyMember")
    public void createFamilyMember(@RequestBody FamilyMember familyMember) {
        String SQL = "Insert into FamilyMember(familyName,givenName,familyId) values('" + familyMember.getFamilyName() + "','" + familyMember.getGivenName() + "'," + familyMember.getFamilyId() + ")";
        Config.getJdbcTemplate().update(SQL);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/searchFamilyMember")
    public Object searchFamilyMember(@RequestBody FamilyMember familyMember) {
        String SQL = "Select * from FamilyMember where familyId=" + familyMember.getFamilyId();
        SqlRowSet rs = Config.getJdbcTemplate().queryForRowSet(SQL);
        ArrayList<FamilyMember> FamilyList = new ArrayList<>();
        while (rs.next()) {
            FamilyList.add(new FamilyMember(
                    rs.getInt("familyId"),
                    rs.getString("familyName"),
                    rs.getString("givenName"),
                    rs.getInt("id")));
        }
        Gson gson = new Gson();
        String response = "[";
        for (FamilyMember familyMember1 : FamilyList) {
            response = response + gson.toJson(familyMember1, FamilyMember.class) + ",";
        }
        if (response.endsWith(",")) {
            response = response.substring(0, response.length() - 1) + "]";
        }
        return response;
    }

}
