package DSA;

import symbols.Array;

import java.util.Arrays;

public class MergeSort {
    private int[] array;

    /**
     * 时间复杂度：O(nlgn)
     * 空间复杂度：O(n)
     * 是否为稳定排序：是
     * @param array
     */
    public MergeSort(int[] array) {
        this.array = array;
    }
    public int[] sort() {
        int length = array.length;
        int[] result = new int[length];
        merge_sort(array, result, 0, length - 1);
        return result;
    }
    public void merge_sort(int[] array, int[] result, int start , int end) {
        if (start >= end) return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid, start2 = mid + 1, end2 = end;
        merge_sort(array, result, start1, end1);    //二分法，分治左半边、右半边
        merge_sort(array, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        while (start1 <= end1)                      //把有剩余元素的数组也加到结果
            result[k++] = array[start1++];
        while (start2 <= end2)
            result[k++] = array[start2++];
        for (k = start; k <= end; k++)              //把排序结果存回原来的数组
            array[k] = result[k];
    }
    public static void main(String[] args) {
        int[] array = {3,2,4,1,6,9,14,2,5,7,0};
        new MergeSort(array).sort();
        System.out.println(Arrays.toString(array));
    }
}
