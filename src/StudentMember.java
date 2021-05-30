public class StudentMember extends DefaultMember{

    private String schoolName;
    private String grade;
    private String haveNicOrNot;

    public StudentMember(String membershipNum, String firstName, String startMembershipDate, String weight, String height
    ,String schoolName,String grade,String haveNicOrNot ) {
        super(membershipNum, firstName, startMembershipDate, weight, height);
        this.schoolName=schoolName;
        this.grade=grade;
        this.haveNicOrNot=haveNicOrNot;
    }



    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHaveNicOrNot() {
        return haveNicOrNot;
    }

    public void setHaveNicOrNot(String haveNicOrNot) {
        this.haveNicOrNot = haveNicOrNot;
    }







}


