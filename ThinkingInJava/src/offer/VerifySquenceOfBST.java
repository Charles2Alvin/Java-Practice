package offer;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int n = sequence.length;
        if (n == 0) return false;
        if (n == 1) return true;
        return verify(sequence, 0, n);
    }
    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end || start < 0) return true;
        int i, j, root = sequence[end-1];
        for (i = start; i < end; i++) {
            if (sequence[i] > root)
                break;
        }
        for (j = i; j < end; j++) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        left = verify(sequence, start, i-1);
        boolean right = verify(sequence, i, end-1);
        return left && right;
    }
}
