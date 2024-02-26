public class lowerBound {
    public static void main(String[] args) {
        int [] arr= new int[]{1, 2, 2, 3, 3, 5};
        int x=2;
        int l=0;
        int r=arr.length-1;
        int ans=arr.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=x){
                ans=Math.min(ans, mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println(ans);
    }
}
