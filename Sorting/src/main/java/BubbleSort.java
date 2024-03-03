/**
 * Bubble Sort is the sorting algorithm that works by repeatedly swapping the adjacent
 * elements if they are in the wrong order. After each iteration or pass, the largest
 * element reaches the end (in case of ascending order) or the smallest element reaches
 * the end (in case of descending order). The pass through the list is repeated until the
 * list is sorted. This algorithm is not suitable for large data sets as its average
 * and worst-case complexity are of Ο(n^2) where n is the number of items
 */
public class BubbleSort {
    static int[] arr;
    public static void main(String[] args) {
        int n=Integer.valueOf(args[0]);
        arr=new int[n];
        for(int i=0 ;i<n;i++){
            arr[i]=Integer.valueOf(args[i+1]);
        }
        print();
        bubbleSort();

    }
    public static void bubbleSort(){
        for(int i=0;i<arr.length;i++){
            int swapped=0;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=1;
                }
            }
            if(swapped==0){
                break;
            }
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
