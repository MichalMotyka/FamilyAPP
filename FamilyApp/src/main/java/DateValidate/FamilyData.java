package DateValidate;

import java.util.ArrayList;

public class FamilyData {

    //Data validation of age matching
    public static int validateFamilyData(ArrayList MembersList, int nrOfInfants, int nrOfChildren, int nrOfAdults) {
        int countInfants = 0, countChildren = 0, countAdults = 0;
        for (Object member : MembersList) {
            int age = Integer.parseInt(String.valueOf(member).split("age=")[1].replace("}", ""));
            if (age < 0) {
                return 2;
            }
            if (age > 16) {
                countAdults++;
            } else if (age < 4) {
                countInfants++;
            } else {
                countChildren++;
            }
        }
        if (countAdults != nrOfAdults || countInfants != nrOfInfants || countChildren != nrOfChildren) {
            return 1;
        }

        return 0;
    }
}
