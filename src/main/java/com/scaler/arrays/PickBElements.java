package com.scaler.arrays;

// return max sum that can be obtained by picking elements from corners.
public class PickBElements {
    public static void main(String[] args) {
        int[] arr = {2,6,3,-1,4,8,2,7,6,5};
        PickBElements pb = new PickBElements();
        System.out.println(pb.pickB(arr, 4));
    }
    public long pickB(int[] arr, int B) {
        long sum = 0L;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < B; i++) {
            sum += arr[i];
        }

        ans = Math.max(ans, sum);

        int p1 = B - 1;
        int p2 = arr.length - 1;

        while (p1 >= 0) {
            sum = sum - arr[p1] + arr[p2];
            ans = Math.max(ans, sum);
            p1--;
            p2--;
        }

        return ans;
    }
}
