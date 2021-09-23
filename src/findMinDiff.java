public class findMinDiff {

    // Returns maximum sum in a subarray of size k.
    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */

        int L[] = new int[n1];
        int R[] = new int[n2];


        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;


        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;

            } else {
                arr[k] = R[j];
                j++;

            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void printArray(int A[], int size) {
        int i;

        for (i = 0; i < size; i++) {
            System.out.print(A[i]);
        }
        System.out.println("");
    }


    public static int findMinDiff(int[] arr, int n) {
        // Returns minimum difference between any pair
        // Sort array in non-decreasing order
        //   Arrays.sort(arr);
        // Initialize difference as infinite
        int[] org = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            org[i] = arr[i];
        }
        sort(arr, 0, arr.length - 1);

        int[] pair = new int[2];
        int[] pairIdx = new int[2];
        pairIdx[0] = Integer.MAX_VALUE;
        pairIdx[1] = Integer.MAX_VALUE;


        System.out.println("findMindDiff");
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing adjacent
        // pairs in sorted array

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) < diff) {
                diff = arr[i + 1] - arr[i];
                pair[0] = arr[i];
                pair[1] = arr[i + 1];
                System.out.println(i + " " + (i + 1));
            }
        }

        for (int i = 0; i < org.length; i++) {
            if (org[i] == pair[0] || org[i] == pair[1]) {
                if (pairIdx[0] == Integer.MAX_VALUE) {
                    pairIdx[0] = i;
                } else {
                    pairIdx[1] = i;
                }
            }
        }
        System.out.println(pairIdx[0] + " " + pairIdx[1]);
        // Return min diff
        return diff;

    }

    public static void main(String[] args) {
        // int arr[] = new int[]{1, 5, 3, 19, 18, 2};
        int arr[] = new int[]{4, 2, 8, 1, 2, 0, 3};
        // MergeSort merge = new MergeSort();
        printArray(arr, arr.length);
        System.out.println("Minimum difference is " + findMinDiff(arr, arr.length));
    }

}


