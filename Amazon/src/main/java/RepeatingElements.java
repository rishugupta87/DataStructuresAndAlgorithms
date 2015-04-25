/**
 * Created by rg029761 on 10/17/15.
 */
public class RepeatingElements {

    static void printRepeating(int arr[], int size)
    {
        int i;

        System.out.println("\n The repeating elements are");

        for(i = 0; i < size; i++)
        {
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.printf(" %d ", Math.abs(arr[i]));
        }
    }

    public static void main(String args[])
    {
        int arr[] = {1, 1, 2, 3, 4, 5, 6, 2, 1};
        printRepeating(arr, 9);
    }
}
