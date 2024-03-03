import java.util.Arrays;

/**
 * In Insertion Sort
 * At iteration 'x' till index 'x' elements will be sorted
 * Adaptive
 * Simple
 * O(N2)
 *
 * Insertion sort is a simple sorting algorithm that works similarly to the way you
 * sort playing cards in your hands. The array is virtually split into a sorted and
 * an unsorted part. Values from the unsorted part are picked and placed at the
 * correct position in the sorted part. Insertion sort is fast and best suitable
 * either when the problem size is small (because it has low overhead) or when
 * the data is nearly sorted (because it is adaptive).
 */
public class InsertionSort {
    static int[] arr;

    public static void main(String[] args) {
        int n=Integer.valueOf(args[0]);
            arr=new int[n];
        for(int i=0 ;i<n;i++){
            arr[i]=Integer.valueOf(args[i+1]);
        }
        print();
        insertionSort();
    }

    public static void insertionSort(){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
            print();
        }
    }
    public static void print(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
