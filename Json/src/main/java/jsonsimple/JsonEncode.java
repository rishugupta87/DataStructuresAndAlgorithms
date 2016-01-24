package jsonsimple; /**
 * Created by rg029761 on 11/14/15.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class JsonEncode {

    public static void main(String[] args){
        normalEncode();
        encodeUsingMap();
        encodeUsingList();
    }

    public static void normalEncode() {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));
        obj.put("test", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);


        System.out.print(obj);
    }

    public static void encodeUsingMap() {
        System.out.println();
        Map obj=new LinkedHashMap();
        obj.put("name","foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));
        obj.put("nickname",null);

        String jsonText = JSONValue.toJSONString(obj);
        System.out.print(jsonText);
    }

    public static void encodeUsingList() {
        System.out.println();
        LinkedList list = new LinkedList();
        list.add("foo");
        list.add(new Integer(100));
        list.add(new Double(1000.21));
        list.add(new Boolean(true));
        list.add(null);
        String jsonText = JSONValue.toJSONString(list);
        System.out.print(jsonText);
    }
}
