package offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class MoreThanHalf {
    /**
     * 摩尔投票法
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 0, num = array[0], n = array.length;
        for (int i = 1; i < n; i++) {
            if (array[i] == num) {
                count++;
            } else if (count == 0) {
                num = array[i];
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++){
            if (array[i] == num) {
                count++;
            }
        }
        return count > n >> 1 ? num : 0;
    }
}