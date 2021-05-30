public class Over60Members extends DefaultMember {

    private int age;
    private String occupation;
    private String marriedOrUnmarried;

    public Over60Members(String membershipNum, String firstName, String startMembershipDate, String weight, String height,int age,String occupation,String marriedOrUnmarried) {
        super(membershipNum, firstName, startMembershipDate, weight, height);
        int setAge = (age);
        this.occupation=occupation;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAccessException {
        if (age >=60) {
            this.age = age;
        }else{
            throw new IllegalAccessException("Invalid age!! You should be over 60");
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMarriedOrUnmarried() {
        return marriedOrUnmarried;
    }

    public void setMarriedOrUnmarried(String marriedOrUnmarried) {
        this.marriedOrUnmarried = marriedOrUnmarried;
    }

}
