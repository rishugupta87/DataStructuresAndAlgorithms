package array;

/**
 * Created by rg029761 on 11/10/15.
 */
public class Factors {


    public static void printPrimeFactors(long n) {
        // command-line argument
        System.out.print("The prime factorization of " + n + " is: ");

        // for each potential factor i
        for (long i = 2; i*i <= n; i++) {

            // if i is a factor of N, repeatedly divide it out
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }

        // if biggest factor occurs only once, n > 1
        if (n > 1) System.out.println(n);
        else       System.out.println();
    }


    public static void printUniqueFactors(long n) {
        for(int i = 1; i <= n/2; i++) {
            if(n % i == 0)
            System.out.print(i + " ");
        }
    }

    public static void printUniqueFactorsCombination(int number, String parentFactors, int parentVal) {
        int newVal = parentVal;
        for (int i = number - 1; i >= 2; i--) {

            if (number % i == 0) {
                if (newVal > i) {
                    newVal = i;
                }
                if (number / i <= parentVal && i <= parentVal
                        && number / i <= i) {
                    System.out.println(parentFactors + i + "*" + number / i);
                    newVal = number / i;
                }

                if (i <= parentVal) {
                    printUniqueFactorsCombination(number / i, parentFactors + i + "*", newVal);
                }
            }

        }
    }

    public static void main(String[] args) {
        printPrimeFactors(24);
        printUniqueFactors(24);
        printUniqueFactorsCombination(24,"",24);
    }
}
