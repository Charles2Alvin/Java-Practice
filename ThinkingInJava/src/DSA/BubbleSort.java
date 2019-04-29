package DSA;

import java.util.Arrays;
/**
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 是否为稳定排序：是
 */
public class BubbleSort {
    private int[] array;
    public BubbleSort(int[] array) {
        this.array = array;
    }
    public void sort() {
        int n = array.length, p, max;
        for (int i = 0; i < n; i++) {
            p = i; max = array[i];
            for (int j = i; j < n; j++) {
                if (array[j] < max) {
                    p = j;
                    max = array[j];
                }
            }
            swap(p, i);
        }
    }
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,2,4,1,6,9,14,2,5,7,0};
        new BubbleSort(array).sort();
        System.out.println(Arrays.toString(array));
    }
}
