/**
 * https://www.geeksforgeeks.org/quick-sort/
 */
public class QuickSort {
    static int[] arr;
    public static void main(String[] args) {
        int n=Integer.valueOf(args[0]);
        arr=new int[n];
        for(int i=0 ;i<n;i++){
            arr[i]=Integer.valueOf(args[i+1]);
        }
        print();
        quickSort(0, arr.length-1);
        print();
    }
    public static void quickSort(int l, int r){
        if(l<r){
            int partition = partition(l, r);
            quickSort(l, partition -1);
            quickSort(partition+1, r);
        }
    }
    public static int partition(int l, int r){
        int pivot=arr[r];
        int i=l-1;
        for(int j=l;j<r;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        return i+1;
    }
    public static void print(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
