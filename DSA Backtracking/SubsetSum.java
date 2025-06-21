//Subset sum 1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3};
        List<Integer> result = new ArrayList<>();
        subsetSums(0, 0 , arr, result);
        Collections.sort(result); //to return in non decreasing order
        System.out.println(result);
    }

    public static void subsetSums(int index, int currentSum, int[] arr, List<Integer> result) {
        if (index == arr.length) {
            result.add(currentSum);
            return;
        }

        //include current element
        subsetSums(index + 1, currentSum + arr[index], arr, result);

        //exclude current element
        subsetSums(index + 1, currentSum, arr, result);
    }
}