package robert;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rg029761 on 8/12/15.
 */
public class FindIntersectionTest {

    /**
     * There are 2 "unsorted" lists that have elements which could repeat List A (Fremont, Dublin, San Jose, SFO)
     * List B (Livermore, Fremont, Dublin) Write pseudo or Java code to create a l
     * ist that has cities that are common in List A and List B sorted alphabetically. Example: (Dublin, Fremont)
     */
    @Test
    public void test1() {
        final List<String> listA = Arrays.asList("Fremont", "Dublin", "anamole", "San Jose" , "SFO", "Dublin", "San Jose", "paramount", "y");
        final List<String> listB = Arrays.asList("Dublin", "san mateo", "los angeles", "san mateo", "fremont", "anamole", "x", "x", "Y");
        final List<String> common = FindIntersection.findCommonLists(listA, listB);
        System.out.println(Arrays.toString(FindIntersection.findCommonLists(listA, listB).toArray()));

    }
}
