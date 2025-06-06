
// 169. Majority Element

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int majority = num[0], votes = 1;

        for (int i = 1; i < nums.length ; i++) {
            if (votes == 0) {
                votes++;
                majority = num[i];
            } else if (majority == num[i]) {
                votes++;
            } else {
            votes--;
            }
             
        }
       return majority;
    }
}