
public class LeftRotateByOne {
    public static void rotateByOne(int[] arr) {
       
        if (arr.length == 0) return;  // checking the edge case if arr has no element

        int first = arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        rotateByOne(arr);
        System.out.println("Rotated: " + java.util.Arrays.toString(arr));
    }
}