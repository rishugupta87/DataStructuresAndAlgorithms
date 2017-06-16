/**
 * Created by rg029761 on 2/19/16.
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        B bobj = new B();

        System.out.println(bobj.a);//2
        System.out.println(bobj.getA());//2

        System.out.println(a.a); // 1
        System.out.println(b.a); //1
        System.out.println(a.getA()); //1
        System.out.println(b.getA()); //2
    }
}
