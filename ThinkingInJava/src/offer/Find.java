package offer;

public class Find {
    public static boolean Find(int target, int [][] array) {
        int row = array.length, up = 0, down = row - 1;
        while (up <= down) {
            int left = 0, right = array[0].length-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[down][mid] == target)
                    return true;
                else if (array[down][mid] > target) {
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }
            down--;
        }
        return false;
    }
    static boolean find(int target, int[] array) {
        int left = 0, right = array.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return true;
            else if (array[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    static boolean betterFind(int target, int[][] array) {
        int row = array.length, col = array[0].length;
        int p = 0, q = col - 1;
        while (p >=0 && q >= 0) {
            if (array[p][q] == target)
                return true;
            else if (array[p][q] > target)
                q--;
            else p--;
        }
        return false;
    }
    public static void main(String[] args) {
        int target = 3;
        int[][] array = {{1,2,3},{4,5,6}};
        int[] nums = {1,2,3,4,5};
        //System.out.println(find(target, nums));
        System.out.println(betterFind(target, array));
    }
}
