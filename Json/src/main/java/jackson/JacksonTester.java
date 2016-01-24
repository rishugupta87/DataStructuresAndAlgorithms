package jackson;

import java.io.IOException;

import jackson.databindings.Student;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * In the following example, we will create a Student class. Thereafter, we will create a JSON string with Student details
 * and deserialize it to Student object and then serialize it back to a JSON string.
 */
public class JacksonTester {
    public static void main(String args[]) {
        test1();
    }

    public static void test1() {
         /* ObjectMapper is the main actor class of Jackson library. ObjectMapper class provides functionalities to convert Java objects to matching
         * JSON constructs and vice versa. It uses instances of JsonParser and JsonGenerator for implementing actual reading/writing of JSON.
         */
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student

        try {
            Student student = mapper.readValue(jsonString, Student.class); //deserialize

            System.out.println(student);

            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(student); //serialize

            System.out.println(jsonString);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}