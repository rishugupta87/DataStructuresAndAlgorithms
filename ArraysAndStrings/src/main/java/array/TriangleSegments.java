package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rg029761 on 11/8/15.
 */
public class TriangleSegments {

    static class Segment {
        int a;
        int b;
        int c;
        public Segment(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    /**
     * Three segments of lengths A, B, C form a triangle iff * * A + B > C , B + C > A , A + C > B * *
     * e.g. 6, 4, 5 can form a triangle * 10, 2, 7 can't * * Given a list of segments lengths algorithm
     * should find at least one triplet of segments thatform a triangle (if any). * * Method should return an array of either:
     * * - 3 elements: segments that form a triangle (i.e. satisfy the condition above) * - empty array if there are no
     * such segments */

     static int getTriangleSides(int[] segments) {
         if (segments == null || segments.length <= 2) {
             return 0;
         }

         Set<Segment> segmentSet = new HashSet<Segment>();
         Arrays.sort(segments);

         int res = 0;
         for (int end = segments.length - 1; end > 1; end--) {
             int start = 0, mid = end - 1;

             while (start < mid) {
                 if (segments[start] + segments[mid] <= segments[end]) {
                     start++;
                 } else {
                     res += mid - start; //key point
                     segmentSet.add(new Segment(segments[start], segments[mid], segments[end]));
                     for (int i = start + 1; i < mid; i++) {
                         segmentSet.add(new Segment(segments[i], segments[mid], segments[end]));
                     }
                     mid--;
                 }
             }
         }

         for(Segment segment : segmentSet) {
             System.out.printf("%d, %d, %d", segment.a, segment.b, segment.c);
             System.out.println();
         }

         return res;
    }

    public int triangleCount(int S[]) {
        if (S == null || S.length <= 2) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for (int end = S.length - 1; end > 1; end--) {
            int start = 0, mid = end - 1;

            while (start < mid) {
                if (S[start] + S[mid] <= S[end]) {
                    start++;
                } else {
                    res += mid - start;//key point
                    mid--;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] segments = {3,8,5,10,12,13,15};
        System.out.println(getTriangleSides(segments));
    }
}
