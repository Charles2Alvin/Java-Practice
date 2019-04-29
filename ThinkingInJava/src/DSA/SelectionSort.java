package DSA;
import java.util.Arrays;
/**
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 是否为稳定排序：是
 */
public class SelectionSort {
    private int[] array;
    public SelectionSort(int[] array) {
        this.array = array;
    }
    public void sort() {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1, key = array[i];  //前面是已排序的，到前面找位子插入
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];    //把元素往后挪
                j--;
            }
            array[j + 1] = key;             //j是比key小的，应该放在j后面
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,2,4,1,6,9,14,2,5,7,0};
        new SelectionSort(array).sort();
        System.out.println(Arrays.toString(array));
    }
}
