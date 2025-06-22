public class LeftRotateByK {

    // Rotate by 1 helper
    public static void leftRotateByOne(int[] arr) {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    // Rotate by k times
    public static void leftRotateByK(int[] arr, int k) {
        if (arr.length == 0) return;
        k = k % arr.length; // Handle cases where k > n
        for (int i = 0; i < k; i++) {
            leftRotateByOne(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        leftRotateByK(arr, k);
        System.out.println("Rotated: " + java.util.Arrays.toString(arr));
    }
}
