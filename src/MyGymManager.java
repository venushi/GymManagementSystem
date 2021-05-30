import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyGymManager implements GymManager, Serializable {
    private List<DefaultMember> memList = new ArrayList<DefaultMember>();

    @Override
    public void addMem(DefaultMember member) {
        System.out.println("Numbers of members : "+ (memList.size()+1));
        System.out.println("Number of free spaces : "+(99-memList.size()));
        System.out.println("_______________---------------");
        if (memList.size()<100) {
            memList.add(member);

        }else{
            System.out.println("No any spaces to a new member.");
        }
    }

    @Override
    public boolean delMem(String membershipNum) {
        boolean gym=false;
        for (DefaultMember member:memList){
            if (member.getMembershipNum().equals(membershipNum)){
                gym=true;
                memList.remove(member);
                System.out.println(membershipNum+"Successfully removed");
                System.out.println("Numbers of members : "+(memList.size()));
                System.out.println("Number of free spaces : "+(100-memList.size() ));

                if (member instanceof StudentMember){
                    System.out.println("Member type is : StudentMember");
                }else if (member instanceof Over60Members) {
                    System.out.println("Member type is : Over60Members");
                }else{
                    System.out.println("Member type is : DefaultMember");

                }
                System.out.println("_______________-----------------");
                break;
            }

        }
        if (!gym){
            System.out.println(membershipNum+"is not found");
        }
        return gym;

    }

    @Override
    public void printListOfMem() {
        for(DefaultMember member:memList){
            System.out.println("Membership Number : "+member.getMembershipNum()+" ");
            if (member instanceof StudentMember){
                System.out.println("Member type is : StudentMember");
            }else if (member instanceof Over60Members) {
                System.out.println("Member type is : Over60Members");
            }else{
                System.out.println("Member type is : DefaultMember");

            }
            System.out.println("First Name is"+member.getFirstName()+"");
            System.out.println("Membership start date is : "+member.getStartMembershipDate());
        }
        if (memList.size()==0){
            System.out.println("The member list is empty!");
        }

    }

    void merge(DefaultMember arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        DefaultMember L[] = new DefaultMember[n1];
        DefaultMember R[] = new DefaultMember[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {

            if (L[i].getFirstName().compareToIgnoreCase(R[j].getFirstName()) < 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void msort(DefaultMember arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            msort(arr, l, m);
            msort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    @Override
    public void sort() {
        DefaultMember[] arr = new DefaultMember[memList.size()];
        memList.toArray(arr);
        msort(arr, 0, memList.size()-1);
        memList.clear();
        for (DefaultMember m : arr) {
            memList.add(m);
        }
    }

    @Override
    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("members.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in members.ser");
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public int getCount() {
        return memList.size();
    }

    @Override
    public List<DefaultMember> getMemList() {
        return this.memList;
    }

    @Override
    public DefaultMember getMembyMembershipNum(String membershipNum) {
        DefaultMember found = null;
        for (int i = 0; i < memList.size(); i++) {
            DefaultMember current = memList.get(i);
            if (current.getMembershipNum().equals(membershipNum)) {
                found = current;
            }
        }
        return found;
    }

    @Override
    public List<DefaultMember> getMembyFirstname(String firstName) {
        List<DefaultMember> found = new ArrayList<DefaultMember>();
        for (int i = 0; i < memList.size(); i++) {
            DefaultMember current = memList.get(i);
            if (current.getFirstName().equalsIgnoreCase(firstName)) {
                found.add(current);
            }
        }
        return found;
    }
}
