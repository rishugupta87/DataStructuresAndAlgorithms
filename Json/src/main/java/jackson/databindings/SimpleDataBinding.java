package jackson.databindings;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * SimpleDataBinding converts JSON to and from Java Maps, Lists, Strings, Numbers, Booleans, and null objects.
 */
public class SimpleDataBinding {

    public static void main(String args[]){
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String,Object> studentDataMap = new HashMap<String, Object>();
            int[] marks = {1,2,3};

            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");

            // JAVA Object
            studentDataMap.put("student", student);

            // JAVA String
            studentDataMap.put("name", "Mahesh Kumar");

            // JAVA Boolean
            studentDataMap.put("verified", Boolean.FALSE);

            // Array
            studentDataMap.put("marks", marks);

            // result student.json
            // {
            //    "student":{"name":"Mahesh","age":10},
            //    "marks":[1,2,3],
            //    "verified":false,
            //    "name":"Mahesh Kumar"
            // }

            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT); //formats json.
            mapper.writeValue(new File("student.json"), studentDataMap);

            studentDataMap = mapper.readValue(new File("student.json"), Map.class);

            System.out.println(studentDataMap.get("student"));
            System.out.println(studentDataMap.get("name"));
            System.out.println(studentDataMap.get("verified"));
            System.out.println(studentDataMap.get("marks"));

        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace();}
        catch (IOException e) { e.printStackTrace();}
    }
}
