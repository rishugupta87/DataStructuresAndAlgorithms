package microsoft;

import java.util.Stack;

public class Person
{
    public String name;
    public Person[] acquantainces;

    public void setAcquantainces(Person[] acquantainces) {
        this.acquantainces = acquantainces;
    }

    public Person(String name) {
        if(name.isEmpty()) {
            throw new RuntimeException();
        }
        this.name = name;
    }

    public boolean mystery(final String name) {

        Stack<Person> stack = new Stack<Person>();
        for(Person acquantaince : acquantainces) {
            stack.push(acquantaince);
        }

        do {
            Person currPerson = stack.pop();

            if(currPerson.name.equals(name))
                return true;

            for(Person acquaintance : acquantainces) {
                stack.push(acquaintance);
            }
        }while(stack.size() >= 0);

        return false;

        }

    public static void main(String args[]) {
        Person A = new Person("A");
        Person D = new Person("D");
        Person B = new Person("B");
        Person C = new Person("C");

        A.setAcquantainces(new Person[]{B, C, D});
        B.setAcquantainces(new Person[]{A, C, D});
        C.setAcquantainces(new Person[]{B, D});
        D.setAcquantainces(new Person[]{}); //celebrity

        A.mystery(A.name);

    }
}
