package duckproblem1;

/**
 * Inheritance all the non private fields and methods of the subclass
 * This duck class if just to showcase inheritance. Duck1 has overriden few methods of duck class except fly and added its own talk method
 * Note sub class cannot override class variables, can just override instance methods. Sub class cannot override final and static method.
 */
public class Duck1 extends Duck {

    public Duck1() {
        System.out.println("duck1 created");
    }

    public void quack() {
        System.out.println("duck1 quack");
    }

    public void swim() {
        super.swim();
        System.out.println("duck1 swim");
    }

    public void display() {
        System.out.println("duck1 display");
    }

    public void talk() {
        System.out.println("duck1 can talk");
    }

    public static void someMethod() {
        System.out.println("sub class some method called");
    }

    public static void main(String[] args) {

        System.out.println("=======Case 1=============");
        Duck superDuck1 = new Duck1(); //parent reference variable can point to a sublass object
        Duck1 duck1 = (Duck1) superDuck1; // for this to work a superclass variable must be pointing to Duck1
        duck1.display();

        /* This will throw ClassCast Exception at runtime
        Duck superDuck2 = new Duck();
        Duck1 duck11 = (Duck1) superDuck2; //this will throw class cast exception since superDuck2 is not pointing to Duck1 object
        duck11.display();
        */

        System.out.println("=========Case 2=============");
        Duck1 duck11 = new Duck1();
        duck11.display();

        System.out.println("=========Case 3=============");
        Duck superDuck2 = new Duck();
        superDuck2.display(); //calls display method in superclass

        System.out.println("=========Case 4=============");
        Duck superDuck3 = new Duck1();
        superDuck3.display(); //calls display method in Duck1, In compile time, the check is made on the reference type.
        // However, in the runtime, JVM figures out the object type and would run the method that belongs to that particular object.

        //System.out.println("=========Case 5=============");
        //Duck superDuck4 = new Duck1();
        //superDuck4.fly(); //compile time since superDuck4 reference type Duck does not have this method

        //System.out.println("=========Case 6=============");
        //Duck superDuck4 = new Duck1();
        //superDuck4.talk(); //compile time since superDuck4 reference type Duck does not have this method

        System.out.println("=========Case 7=============");
        Duck superDuck4 = new Duck1();
        superDuck4.fly();

        System.out.println("=========Case 8=============");
        Duck1 duck3 = new Duck1();
        duck3.fly(); //duck3 inherited method of Duck class

        System.out.println("=========Case 9=============");
        Duck superduck5 = new Duck1();
        superduck5.someMethod(); //this calls super class someMethod, in short someMethod does not get overriden here.

        System.out.println("=========Case 10=============");
        Duck1 duck4 = new Duck1();
        duck4.someMethod(); //this calls super class someMethod, in short someMethod does not get overriden here.
    }
}
