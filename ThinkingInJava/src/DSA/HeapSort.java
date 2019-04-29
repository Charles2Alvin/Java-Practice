package DSA;

import java.util.Arrays;

public class HeapSort {
    /**
     * 时间复杂度：O(nlgn)
     * 空间复杂度：O(1)
     * 是否为稳定排序：不是
     */
    private int[] array;
    public HeapSort(int[] array) {
        this.array = array;
    }
    /**
     * 构建最大堆
     */
    public void sort() {
        int end = array.length - 1;
        int beginIndex = (end - 1) >> 1;     //从第一个非叶结点开始
        for (int i = beginIndex; i >= 0; i--)   //每一个父节点所在子树都需满足堆性质
            maxHeapify(i, end);
        for (int i = end; i > 0; i--) {
            swap(0, i);                       //把堆顶（最大值）移到末尾
            maxHeapify(0, i - 1);    //恢复堆序
        }
    }
    /**
     *  使下标为index的结点符合堆的性质，即父节点大于两个孩子（大根堆）
     */
    public void maxHeapify(int parent, int end) {
        int left = (parent << 1) + 1, right = left + 1; //先找出左右孩子的下标
        int maxChild = left;
        if (left > end) return;                        //如果下标越界，返回
        if (array[left] < array[right] && right <= end) maxChild = right;
        if (array[parent] < array[maxChild]) {          //当父节点小于孩子时，需要替换
            swap(parent, maxChild);
            maxHeapify(maxChild, end);                  //以父节点为根的子树都需满足堆性质
        }
    }
    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {3,2,4,1,6,9,14,2,5,7,0};
        new HeapSort(array).sort();
        System.out.print(Arrays.toString(array));
    }
}
