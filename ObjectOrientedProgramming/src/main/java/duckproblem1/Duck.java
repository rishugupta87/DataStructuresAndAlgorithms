package duckproblem1;

/**
 * Created by rg029761 on 2/27/16.
 */
public class Duck {

    private int a;
    protected int b;
    public int c;
    int d;

    public Duck() {
        System.out.println("super duck is created");
    }

    public void quack() {
        System.out.println("super duck quack");
    }

    public void swim() {
        System.out.println("super duck swim");
    }

    public void display() {
        System.out.println("super duck display");
    }

    public void fly() {
        System.out.println("super duck can fly");
    }

    public static void someMethod() {
        System.out.println("super some method called");
    }
}
