/**
 * A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in. If
 */
class B extends A {
    public int a = 2;

    int getA() {
        return a;
    }
}