/**
 * https://www.geeksforgeeks.org/heap-sort/
 * https://www.youtube.com/watch?v=HqPJF2L5h9U
 */
public class HeapSort {
    static int[] arr;
    public static void main(String[] args) {
        int n=Integer.valueOf(args[0]);
        arr=new int[n];
        for(int i=0 ;i<n;i++){
            arr[i]=Integer.valueOf(args[i+1]);
        }
        print();
        heapSort();
        print();
    }
    static void heapSort(){
        for(int x=arr.length/2;x>=0;x--){
            heapify(x, arr.length);
        }
        for(int x=arr.length-1;x>=0;x--){
            int temp=arr[0];
            arr[0]=arr[x];
            arr[x]=temp;
            heapify(0, x);
        }

    }
    static void heapify(int i, int length){
        int largest=i;
        int l=2*i;
        int r=2*i+1;
        if(l<length && arr[l]>arr[largest]){
            largest=l;
        }
        if(r<length && arr[r]>arr[largest]){
            largest=r;
        }
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(largest, length);
        }
    }

    public static void print(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
