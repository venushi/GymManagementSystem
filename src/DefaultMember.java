import java.io.Serializable;

public class DefaultMember implements Comparable<DefaultMember>, Serializable {
    private String membershipNum;
    private String firstName;
    private String startMembershipDate;
    private String weight;
    private String height;

    public DefaultMember(String membershipNum,String firstName,String startMembershipDate,String weight,String height) {
        super();
        this.membershipNum = membershipNum;
        this.firstName = firstName;
        this.startMembershipDate= startMembershipDate;
        this.weight=weight;
        this.height=height;
    }

    public DefaultMember(String membershipNum) {

    }

    public DefaultMember(String jane, String deer) {
    }

    public String getMembershipNum() {
        return membershipNum;
    }

    public void setMembershipNum(String membershipNum) {
        this.membershipNum = membershipNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }


    @Override
    public int compareTo(DefaultMember o) {
        return this.firstName.compareTo(o.getFirstName());
    }
}


















