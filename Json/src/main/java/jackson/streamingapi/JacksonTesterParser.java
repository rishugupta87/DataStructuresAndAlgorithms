package jackson.streamingapi;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.File;
import java.io.IOException;

/**
 * Created by rg029761 on 11/14/15.
 */
public class JacksonTesterParser {

    public static void main(String args[]) throws IOException {
        try {
            JsonFactory jasonFactory = new JsonFactory();

            JsonGenerator jsonGenerator = jasonFactory.createJsonGenerator(new File("student.json"), JsonEncoding.UTF8);
            jsonGenerator.writeStartObject();

            jsonGenerator.writeStringField("name", "Mahesh Kumar");
            jsonGenerator.writeNumberField("age", 21);

            jsonGenerator.writeBooleanField("verified", false);
            jsonGenerator.writeFieldName("marks");

            jsonGenerator.writeStartArray(); // [

            jsonGenerator.writeNumber(100);
            jsonGenerator.writeNumber(90);
            jsonGenerator.writeNumber(85);

            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();

            jsonGenerator.close();

            //result student.json

            //{
            //   "name":"Mahesh Kumar",
            //   "age":21,
            //   "verified":false,
            //   "marks":[100,90,85]
            //}

            org.codehaus.jackson.JsonParser jsonParser = jasonFactory.createJsonParser(new File("student.json"));

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                //get the current token
                String fieldname = jsonParser.getCurrentName();

                if ("name".equals(fieldname)) {
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText());
                }

                if("age".equals(fieldname)){
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getNumberValue());
                }

                if("verified".equals(fieldname)){
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getBooleanValue());
                }

                if("marks".equals(fieldname)){
                    //move to [
                    jsonParser.nextToken();
                    // loop till token equal to "]"

                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println(jsonParser.getNumberValue());
                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
