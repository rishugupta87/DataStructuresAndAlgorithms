package microsoft;

/**
 * Created by rg029761 on 11/1/15.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CelebrityIdentifier {
    /**
     * @param args
     */

    Stack<Member> membersStack = new Stack<Member>();
    static Member noCelebrity = null;

    private static class Member{
        private List<Member> acquintanceList = new ArrayList<Member>();
        String name;

        public List<Member> getAcquintanceList() {
            return acquintanceList;
        }

        public void setAcquintanceList(List<Member> acquintanceList) {
            this.acquintanceList = acquintanceList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Member findCelebrity(){
        while(membersStack.size() != 1){
            Member m1 = membersStack.pop();
            Member m2 = membersStack.pop();
            Member contenderForCelebrity = hasAcquintance(m1,m2);
            membersStack.push(contenderForCelebrity);
        }
        Member canBeCelebrity = membersStack.pop();
        Boolean isCelebrity = checkIfCelebrity(canBeCelebrity);
        if(isCelebrity)
            return canBeCelebrity;
        return noCelebrity;
    }

    private Member hasAcquintance(Member m1,Member m2){
        if(m1.getAcquintanceList().contains(m2))
            return m2;
        else
            return m1;
    }

    private Boolean checkIfCelebrity(Member canBeCelebrity){
        if(canBeCelebrity.getAcquintanceList().size() == 0)
            return true;
        return false;
    }

    public CelebrityIdentifier(){
        Member A = new Member();
        Member B = new Member();
        Member C = new Member();
        Member D = new Member();

        A.setName("A");
        B.setName("B");
        C.setName("C");
        D.setName("D");

        List<Member> acquintanceListForA = new ArrayList<Member>();
        List<Member> acquintanceListForB = new ArrayList<Member>();
        List<Member> acquintanceListForD = new ArrayList<Member>();
        acquintanceListForA.add(C);
        acquintanceListForB.add(C);
        acquintanceListForD.add(C);

        A.setAcquintanceList(acquintanceListForA);
        B.setAcquintanceList(acquintanceListForB);
        D.setAcquintanceList(acquintanceListForD);

        membersStack.push(A);
        membersStack.push(B);
        membersStack.push(C);
        membersStack.push(D);
    }

    public static void main(String[] args) {
        CelebrityIdentifier ci = new CelebrityIdentifier();
        Member celebrity = ci.findCelebrity();

        if(celebrity.equals(noCelebrity))
            System.out.println("No celebrities!");
        else
            System.out.println("Celebrity is-->"+celebrity.getName());
    }

}