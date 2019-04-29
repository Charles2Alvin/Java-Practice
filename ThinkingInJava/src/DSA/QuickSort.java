package DSA;

import java.util.Arrays;

public class QuickSort {
    /**
     * 时间复杂度：O(nlgn)
     * 空间复杂度：O(lgn)
     * 是否为稳定排序：是
     * @param array
     */
    public int[] array;
    public QuickSort(int[] array) {
        this.array = array;
    }
    public void sort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            sort(array, low, index);
            sort(array, index+1, high);
        }
    }
    public int partition(int[] array, int low, int high) {
        int index = low + (int)(Math.random()*(high - low + 1));
        swap(index, low);           //在数组中随机选取一个元素与首元素互换，相当于首元素随机
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot)
                high--;
            array[low] = array[high];
            while (low < high && array[low] < pivot)
                low++;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
    public void swap(int i, int j) {
        /* try to note */ int temp = array[i]; /* what if like this? */
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {3,2,4,1,6,9,14,2,5,7,0};
        QuickSort q = new QuickSort(array);
        q.sort(q.array, 0, q.array.length - 1);
        System.out.print(Arrays.toString(array));
//        int a = 1;
//        double b = 2.0;
//        a = b;
    }
}
