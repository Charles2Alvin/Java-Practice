package offer;

public class JumpFloor {
    public int JumpFloor(int target) {
        if (target <= 3) return target;
        int[] a = new int[target+1];
        a[0] = 0; a[1] = 1; a[2] = 2;
        for (int i = 3; i < target+1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[target];
    }
    public int JumpFloorII(int target) {
        if (target < 3) return target;
        int[] a = new int[target+1];
        a[0] = 0; a[1] = 1;
        for (int i = 2; i < target+1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++)
                sum += a[j];
            a[i] = sum + 1;
        }
        return a[target];
    }
    public static void main(String[] args) {
        System.out.println(new JumpFloor().JumpFloor(4));
    }
}
