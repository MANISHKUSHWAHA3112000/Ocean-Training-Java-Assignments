package memberapplication;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/** Memeber Class to demonstrate id,name,address**/

class Member {
	
	/** Member Variable**/
	
    private int memberId;
    private String memberName;
    private String address;

    /** Constructors, getters, and setters... **/

    public Member() {
    }

    /** Constructor with parameters**/
    public Member(final int memberId, final String memberName, final String address) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
    }

    /**Getters and setters...**/

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getAddress() {
        return address;
    }
}

class Library {
    /**
     * Collection to store members
     **/
    private List<Member> memberList = new ArrayList<>();

    /**
     * Add a member to the library
     **/
    public void addMember(final Member memberObj) {
        memberList.add(memberObj);
    }

    /**
     * View all members in the library
     **/
    public List<Member> viewAllMembers() {
        // Return a copy of the member list to prevent modification outside the class
        return new ArrayList<>(memberList);
    }

    /**
     * View members in the library by address
     **/
    public List<Member> viewMembersByAddress(final String address) {
        final List<Member> result = new ArrayList<>();
        for (final Member member : memberList) {
            // Case-insensitive comparison for address
            if (member.getAddress().equalsIgnoreCase(address)) {
                result.add(member);
            }
        }
        return result;
    }
}

public class Assignment13Q1 {

    // JUnit test method
    @Test
    void testLibrary() {
        // Create an instance of the Library class
        final Library library = new Library();

        // Test cases...

        // Add a test member
        final Member testMember = new Member(1, "John Doe", "123 Main St");
        library.addMember(testMember);

        // Retrieve all members
        final List<Member> allMembers = library.viewAllMembers();
        assert allMembers.size() == 1;

        // Search members by address
        final List<Member> membersByAddress = library.viewMembersByAddress("123 Main St");
        assert membersByAddress.size() == 1;
        assert membersByAddress.get(0).getMemberId() == 1;
        assert membersByAddress.get(0).getMemberName().equals("John Doe");
        assert membersByAddress.get(0).getAddress().equals("123 Main St");
    }

    // Other methods...
}
