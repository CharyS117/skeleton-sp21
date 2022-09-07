package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.lang.annotation.Target;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> AListA = new AListNoResizing<>();
        BuggyAList<Integer> AListB = new BuggyAList<>();
        for(int j:new int[]{4,5,6}){
            AListA.addLast(j);
            AListB.addLast(j);
        }
        for(int i=0;i<3;i++){
            assertEquals(AListA.removeLast(),AListB.removeLast());
        }
    }

    @Test
    public void randomTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = L2.size();
                assertEquals(size,size2);
//                System.out.println("size: " + size);
            } else if (operationNumber == 2 && L.size()>0){
                // remove
                int popItem = L.removeLast();
                int popItem2 = L2.removeLast();
                assertEquals(popItem,popItem2);
//                System.out.println("remove("+popItem+")");
            }
        }
    }

}
