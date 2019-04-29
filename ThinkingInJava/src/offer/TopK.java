package offer;
import java.util.*;
public class TopK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int low = 0, high = input.length-1;
        int index = partition(input, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
                index = partition(input, low, high);
            } else {
                low = index + 1;
                index = partition(input, low, high);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && pivot <= nums[high])
                high--;
            nums[low] = nums[high];
            while (low < high && pivot >= nums[low])
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] input = {4,5,1,6,2,7,3,8,9,6,2,1};

        System.out.println(topK.GetLeastNumbers_Solution(input, 4));
    }
}