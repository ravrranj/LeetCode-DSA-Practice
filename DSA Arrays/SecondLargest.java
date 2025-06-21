
//second largest sorting method 0(n^@)

public class SecondLargest {
   public static void secondLargest(int[] a) {


        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("second largest element is:" +  a[1]);
    }
}