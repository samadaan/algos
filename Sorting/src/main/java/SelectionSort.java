/**
 * The selection sort algorithm sorts an array by repeatedly finding the
 * minimum element (considering ascending order) from the unsorted part
 * and putting it at the beginning. The algorithm maintains two subarrays in a given array:
 *
 * The subarray which is already sorted
 * Remaining subarray which is unsorted
 * In every iteration/pass of selection sort,
 * the minimum element (considering ascending order) from the unsorted subarray is
 * picked and moved to the sorted subarray. The selection sort has the property of
 * minimizing the number of swaps. Therefore, it is the best choice when the cost
 * of swapping is high.
 */
public class SelectionSort {
    static int[] arr;
    public static void main(String[] args) {
        int n=Integer.valueOf(args[0]);
        arr=new int[n];
        for(int i=0 ;i<n;i++){
            arr[i]=Integer.valueOf(args[i+1]);
        }
        print();
        selectionSort();

    }
    public static void selectionSort(){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
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
