import java.util.Arrays;
import java.util.Random;

/**
 * Created by kevin on 8/5/2019.
 * Implements a multithreaded merge sort and compares the runtime to serial merge sort.
 */
public class MergeSort {
    public static void main(String[] args) {
        //interesting to note that multithreading actually results in reduced performance for small sets of data
        //multithreading does pull ahead on very large data sets, however
        int[] arr = new int[1000000];

        //specify number of threads you want to use
        int threads = 4;

        Random rand = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(239487) + 1;
        }
        int[] copyArr = arr.clone();
        System.out.println("Given array size to sort: " + arr.length);
        System.out.println();

        System.out.println("Starting merge sort with multithreading...");
        Long start = System.currentTimeMillis();
        multiThreadedMergeSort(arr, threads);
        Long end = System.currentTimeMillis();
        System.out.println("Merge sort with multithreading (" + threads + " threads) took " + (end - start) + " milliseconds");
        System.out.println();

        System.out.println("Starting merge sort without multithreading...");
        start = System.currentTimeMillis();
        mergeSort(copyArr);
        end = System.currentTimeMillis();
        System.out.println("Merge sort without multithreading took " + (end - start) + " milliseconds");

    }
    private static void multiThreadedMergeSort(int[] toSort, int threads) {
        //"base" case
        if(threads <= 1) {
            mergeSort(toSort);
            return;
        }
        int mid = toSort.length /2;
        int[] left = Arrays.copyOfRange(toSort,0, mid);
        int[] right = Arrays.copyOfRange(toSort, mid, toSort.length);

        Thread leftThread = new Thread(() -> multiThreadedMergeSort(left, threads/2));
        Thread rightThread = new Thread(() -> multiThreadedMergeSort(right, threads/2));
        leftThread.start();
        rightThread.start();

        try {
            //wait for threads to terminate
            leftThread.join();
            rightThread.join();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        merge(left, right, toSort);

    }
    //serial/non-parallel version of mergeSort
    private static void mergeSort(int[] toSort) {
        if(toSort.length <= 1) {
            return;
        }
        int mid = toSort.length /2;

        int[] left = Arrays.copyOfRange(toSort, 0, mid);
        int[] right = Arrays.copyOfRange(toSort, mid, toSort.length);
        mergeSort(left);
        mergeSort(right);

        merge(left, right, toSort);

    }

    private static void merge(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
            }
            else {
                c[k++] = b[j++];
            }
        }
        while( i < a.length) {
            c[k++] = a[i++];
        }
        while(j < b.length) {
            c[k++] = b[j++];
        }
    }
}
