// second largest optimized version 0(n)

public class SecondLargest1 {
    public static void findSecondLargest(int[] arr) {

        // for the edge case check
        if(arr.length < 2) {
            System.out.println("Array must contain min. of two elements.");
            return;
        }

        int first = arr[0];
        int second = Integer.MIN_VALUE;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("No distinct second largest element found.");
        } else {
            System.out.println("Second largest element is : " + second);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 14, 12, 21};
        findSecondLargest(arr);
    }
}