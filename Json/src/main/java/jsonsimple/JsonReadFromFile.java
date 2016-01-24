package jsonsimple;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by rg029761 on 11/14/15.
 */
public class JsonReadFromFile {

    public static void main(String args[]) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/Users/rg029761/Documents/home_workspace/DataStructuresAndAlgorithms/Json/src/main/resources/file1.json"));

        JSONObject jsonObj = (JSONObject) obj;

        System.out.println(jsonObj.toJSONString());
        System.out.println(jsonObj.get("Name"));
        System.out.println(jsonObj.get("Author"));

        JSONArray jsonArray = (JSONArray)jsonObj.get("Company List");

        Iterator itr = jsonArray.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("New");
        for(int i = 0 ; i < jsonArray.size(); i++) {
            String obj1 = (String) jsonArray.get(i);
            System.out.println(obj1);
        }
    }
}
