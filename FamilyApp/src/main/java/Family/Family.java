package Family;

import java.util.ArrayList;

public class Family {
    private final String familyName;
    private final int nrOfInfants;
    private final int nrOfChildren;
    private final int nrOfAdults;
    private final ArrayList<Object> FamilyMember;
    private final int id;

    public Family(String familyName, int nrOfInfants, int nrOfChildren, int nrOfAdults, ArrayList<Object> familyMember, int id) {
        this.familyName = familyName;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
        FamilyMember = familyMember;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getNrOfInfants() {
        return nrOfInfants;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public ArrayList<Object> getFamilyMember() {
        return FamilyMember;
    }
}
