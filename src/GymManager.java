import java.io.IOException;
import java.util.List;

public interface GymManager {
    public void addMem(DefaultMember member);
    public boolean delMem(String membershipNum);
    public void printListOfMem();
    public void sort();

    public void save();
    public int getCount();
    public List<DefaultMember> getMemList();
    public DefaultMember getMembyMembershipNum(String membershipNum);
    public List<DefaultMember> getMembyFirstname(String firstName);


}

