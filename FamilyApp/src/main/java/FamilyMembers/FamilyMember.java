package FamilyMembers;

public class FamilyMember {
    private final String givenName;
    private final String familyName;
    private final int age;


    public FamilyMember(String givenName, String familyName, int age) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                '}';
    }
}