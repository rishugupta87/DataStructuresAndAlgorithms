package duckproblem1;

/**
 * Created by rg029761 on 2/27/16.
 */
public class Duck2 extends Duck {

    public Duck2() {
        System.out.println("duck2 created");
    }

    public void quack() {
        System.out.println("duck2 quack");
    }

    public void swim() {
        System.out.println("duck2 swim");
    }

    public void display() {
        System.out.println("duck2 display");
    }

    public static void main(String[] args) {
        Duck2 duck1 = new Duck2();
        duck1.fly();
    }
}
