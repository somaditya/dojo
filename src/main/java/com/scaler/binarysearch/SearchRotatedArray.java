package com.scaler.binarysearch;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] A = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int B = 202;

        System.out.println(search(A, B));
    }

    public static int search(final int[] A, int B) {
        int pivot = 0;
        int n = A.length;

        for (int i = 1; i < n; i++) {
            if (A[i] < A[i-1]) {
                pivot = i;
                break;
            }
        }

        int[] arr = rot(A, pivot);

        int pos = bSearch(arr, B);

        if (pos == -1) {
            return pos;
        } else {
            return (pos + pivot) % n;
        }
    }

    public static int bSearch(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static int[] rot(int[] arr, int p) {
        int n = arr.length;
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            out[i] = arr[(i + p) % n];
        }

        return out;
    }
}
