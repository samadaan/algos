public class MergeSort {
    static int[] arr;
    public static void main(String[] args) {
        int n=Integer.valueOf(args[0]);
        arr=new int[n];
        for(int i=0 ;i<n;i++){
            arr[i]=Integer.valueOf(args[i+1]);
        }
        print();
        mergeSort(0, arr.length-1);
        print();


    }
    public static void mergeSort(int l, int r){
        if(l==r)return;
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(l, mid);
            mergeSort(mid+1, r);
            merge(l,r);
        }
    }
    public static void merge(int l, int r){
        int mid=l+(r-l)/2;
        int i=l;
        int j=mid+1;
        int [] newarr=new int[r-l+1];
        int x=0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                newarr[x]=arr[i];
                x++;
                i++;
            }else{
                newarr[x]=arr[j];
                x++;
                j++;
            }
        }
        while(i<=mid){
            newarr[x]=arr[i];
            i++;
            x++;
        }
        while(j<=r){
            newarr[x]=arr[j];
            j++;
            x++;
        }
        int y=0;
        for(int m=l;m<=r;m++){
            arr[m]=newarr[y];
            y++;
        }
    }
    public static void print(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
