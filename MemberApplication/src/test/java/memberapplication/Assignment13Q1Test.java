package memberapplication;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Assignment13Q1Test {

    @Test
    void testLibrary() {
        Library library = new Library();

        // Add a test member
        Member testMember = new Member(1, "Manish Kushwaha", "H.no 572,Semra Gate");
        library.addMember(testMember);

        // Retrieve all members
        List<Member> allMembers = library.viewAllMembers();
        assertEquals(1, allMembers.size());

        // Search members by address
        List<Member> membersByAddress = library.viewMembersByAddress("H.no 572,Semra Gate");
        assertEquals(1, membersByAddress.size());
        assertEquals(1, membersByAddress.get(0).getMemberId());
        assertEquals("Manish Kushwaha", membersByAddress.get(0).getMemberName());
        assertEquals("H.no 572,Semra Gate", membersByAddress.get(0).getAddress());
    }
}
