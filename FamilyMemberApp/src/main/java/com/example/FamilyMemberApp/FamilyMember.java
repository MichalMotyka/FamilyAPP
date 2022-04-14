package com.example.FamilyMemberApp;


public class FamilyMember {
    private final int familyId;
    private final String familyName;
    private final String givenName;
    private final int id;

    public FamilyMember(int familyId, String familyName, String givenName, int id) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.givenName = givenName;
        this.id = id;
    }

    public int getFamilyId() {
        return familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public int getId() {
        return id;
    }
}

