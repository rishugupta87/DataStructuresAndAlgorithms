package equalshashcode;

import java.util.HashMap;

/**
 * Created by rg029761 on 8/20/15.
 */
public class Apple {

    private String color;

    public Apple(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apple apple = (Apple) o;

        return !(color != null ? !color.equals(apple.color) : apple.color != null);

    }
    public static void main(String[] args) {
        Apple a1 = new Apple("green");
        Apple a2 = new Apple("red");

        //Apple a11 = new Apple("green");
        //Apple a22 = new Apple("green");
        //System.out.println(a11.equals(a22)); //will return false if we dont override equals method.

        //hashMap stores apple type and its quantity
        HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
        m.put(a1, 10);
        m.put(a2, 20);
        System.out.println(m.get(new Apple("green")));
    }
}
