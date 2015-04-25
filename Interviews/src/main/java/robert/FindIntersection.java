package robert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rg029761 on 8/12/15.
 */
public class FindIntersection {


    /**
     * Find common elements in the two lists
     *
     * @param listA
     * @param listB
     * @return
     *        common elements in listA and listB sorted alphabetically.
     */
    public static List<String> findCommonLists(final List<String> listA, final List<String> listB) {
        if(listA.isEmpty() || listB.isEmpty()) { //if any one or both the lists are empty there is nothing common in them.
            return Collections.emptyList(); //return empty list
        }

        //iterate over the listA and put in a hashmap. hashmap will not allow duplicate keys
        final Map<String, Integer> mapA = new HashMap<String, Integer>();
        for(final String city : listA) {
            mapA.put(city.toUpperCase(), 1); //converting uppercase in order to ignore case sensitive strings.
                                             // Fremont and fremont should have a match.
        }

        //list containing common elements between listA and listB
        final List<String> commonList = new ArrayList<String>();

        //now iterate over the listB and check if elements in listB exist in mapA
        //if they exist put that element in the common list.
        for(final String city : listB) {
            if(mapA.containsKey(city.toUpperCase())) {
                commonList.add(city.toUpperCase());
            }
        }

        //sort alphabetically
        Collections.sort(commonList);

        return commonList;
    }

}
